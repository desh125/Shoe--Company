
let baseUrl = "http://localhost:8080/shop/data/"

let orderCode;
var items = [];

let customer;
let selectedItem = null;

const customerName = $(`#customerName`)
const orderId = $(`#orderCode`)

const totalTxt = $(`#totalTxt b`)
const netTxt = $(`#netTxt`)
const dateInput = $(`#datetime`)
const empName = $(`#empname`)

document.addEventListener("DOMContentLoaded", function() {
    var path = window.location.pathname;
    if (path.includes("page-add-sale.html")) {
        initialLoadPage01()
    } else if (path.includes("page-list-sale.html")) {
        /*initialLoadPage02()
        searchItemsByName()*/

        console.log("here")
    } else {
        console.log("Unknown page");
    }
});
function initialLoadPage01(){
    getAllItems();
    getNewId()
    searchItemsByName()
    searchCustomerByContact()
    setDateToInput();
    setCashierName();

}


function setCashierName() {

}

function setDateToInput() {
    const currentDate = new Date();

    const formattedDate = ("0" + (currentDate.getMonth() + 1)).slice(-2) + "/"
        + ("0" + currentDate.getDate()).slice(-2) + "/"
        + currentDate.getFullYear() + " "
        + ("0" + currentDate.getHours()).slice(-2) + ":"
        + ("0" + currentDate.getMinutes()).slice(-2) + ":"
        + ("0" + currentDate.getSeconds()).slice(-2);

    dateInput.val(formattedDate);
}
//Generate new ID
function getNewId() {
    $.ajax({
        url: baseUrl + "sale/getId",
        method: "GET",
        async: false,
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            orderCode = res.data;
            orderId.val(orderCode);
        }
    });
}
//search customer
function searchCustomerByContact() {
    const searchInput = document.getElementById('searchCustomer');

    searchInput.addEventListener('change', (event) => {
        searchCustomer(event.target.value);
    });
}
function searchCustomer(value) {
    $.ajax({
        url: baseUrl + "customers?contact_no="+value,
        method: "GET",
        contentType: "application/json",
        success: function (res) {
            customer = res.data;
            customerName.text(customer.name)
        },
        error: function (err) {
            console.error("Error fetching Customer:", err);
            if (err.responseJSON && err.responseJSON.message) {
                let errorMessage;
                errorMessage = err.responseJSON.message;
            }
            alert(errorMessage)
        },
    });
}
//search items
function searchItemsByName() {
    const searchInput = document.getElementById('searchItem');

    searchInput.addEventListener('input', (event) => {
        searchItems(event.target.value)
        if (event.target.value== null){
            getAllItems();
        }
    });
}
//search items ajax
function searchItems(value) {
    $.ajax({
        url: baseUrl + "inventory?name="+value,
        method: "GET",
        contentType: "application/json",
        success: function (res) {
            if (Array.isArray(res)) {
                items = res;
                loadAllItems(items);
            } else {
                console.log("No data received or data is not an array");
            }
        },
        error: function (err) {
            console.error("Error fetching Items:", err);
        }
    });
}
//get All Items
function getAllItems() {
    $.ajax({
        url: baseUrl + "inventory",
        method: "GET",
        contentType: "application/json",
        success: function (res) {
            if (Array.isArray(res)) {
                items = res;
                loadAllItems(items);
            } else {
                console.log("No data received or data is not an array");
            }
        },
        error: function (err) {
            console.error("Error fetching Item:", err);
        }
    });
}
function loadAllItems(items) {
    const tbody = document.querySelector('.data-tables tbody');

    // Clear any existing rows
    tbody.innerHTML = '';

    // Loop through the items array and create rows
    items.forEach((item, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.itemCode}</td>
            <td>${item.description}</td>
            <td>${item.category}</td>
            <td>${item.size}</td>
            <td>Rs. ${item.salePrice}</td>
            <td>${item.qty}</td>
        `;
        // Append the row to the table body
        tbody.appendChild(row);
        scrollToBottom();
        // Add double-click event listener to the row
        row.addEventListener('dblclick', () => {
            selectedItem = item;
            $('#quantityModal').modal('show');
        });
        row.addEventListener('mouseover', () => {
            row.style.cursor = 'pointer';
            row.style.backgroundColor = '#f1f1f1'; // Optional: to change background color on hover
        });
        row.addEventListener('mouseout', () => {
            row.style.backgroundColor = ''; // Reset background color on mouse out
        });
    });

    // Add the event listener for the addItemButton only once
    document.getElementById('addItemButton').addEventListener('click', () => {
        const quantityInput = document.getElementById('itemQuantity').value;
        const quantity = quantityInput ? parseInt(quantityInput, 10) : 1;
        var total = 0;
        var points = 0;

        if (selectedItem.qty < quantity) {
            alert("Too Many QTYs");
        } else {
            addItemToDetailsTable(selectedItem, quantity);
            $('#quantityModal').modal('hide');
            document.getElementById('itemQuantity').value = ''; // Clear the input field

            if (totalTxt.text() == 0) {
                total = 0.00;
            } else {
                total = parseFloat(totalTxt.text()); // Convert to float here
                console.log(total);
            }
//here
            var newTotal = parseFloat(total) + parseFloat(selectedItem.salePrice * quantity);

            points = newTotal/800;
            $(`#pointsTxt`).text(points);
            totalTxt.text(newTotal);
            netTxt.text(newTotal);
        }
    });
}
function scrollToBottom() {
    const tableBody = $('.data-tables tbody');
    tableBody.scrollTop(tableBody[0].scrollHeight);
}

function addItemToDetailsTable(item, quantity) {
    const detailsTableBody = document.querySelector('.tbl-server-info tbody');

    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${item.description}</td>
        <td>${item.itemCode}</td>
        <td>${quantity}</td>
        <td>Rs. ${item.salePrice * quantity}</td>
        <td>
            <div class="d-flex align-items-center list-action">
                <a class="badge badge-info mr-2" data-toggle="tooltip" data-placement="top"  href="#"><i class="ri-eye-line mr-0"></i></a>
                <a class="badge bg-warning mr-2 delete-from-table" data-toggle="tooltip" data-placement="top" href="#"><i class="ri-delete-bin-line mr-0"></i></a>
            </div>
        </td>
    `;

    // Append the new row to the details table body
    detailsTableBody.appendChild(row);

    // Initialize tooltips
    $('[data-toggle="tooltip"]').tooltip();

    // Add event listener to the delete button
    row.querySelector('.delete-from-table').addEventListener('click', function(event) {
        event.preventDefault();
        row.remove();

        var currentTotal = totalTxt.text();
        var currentPoints = $(`#pointsTxt`).text();

        if (parseFloat(currentTotal) - parseFloat(item.salePrice * quantity) == 0){
            totalTxt.text("000");
            netTxt.text("000");
        }
        totalTxt.text(parseFloat(currentTotal) - parseFloat(item.salePrice * quantity));
        netTxt.text(parseFloat(currentTotal) - parseFloat(item.salePrice * quantity));

        $(`#pointsTxt`).text(parseFloat(currentPoints) - (currentTotal/800));

    });
}


document.getElementById('placeOrderButton').addEventListener('click', function () {
    const tbody = document.getElementById('item-details');

    // Create the payment modal
    const paymentModal = document.createElement('div');
    paymentModal.classList.add('modal', 'fade');
    paymentModal.id = 'payment-modal';
    paymentModal.tabIndex = '-1';
    paymentModal.role = 'dialog';
    paymentModal.innerHTML = `
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Payment Method</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <label for="paymentMethod">Select Payment Method:</label>
                    <select id="paymentMethod" class="form-control" style="margin-bottom: 20px;">
                        <option value="cash">Cash</option>
                        <option value="card">Card</option>
                    </select>
                    <div id="cardDetails" style="display: none;">
                        <label for="cardDigits">Last 4 digits of the card:</label>
                        <input type="text" id="cardDigits" maxlength="4" class="form-control" style="margin-bottom: 10px;">
                    </div>
                    <button id="payButton" class="btn btn-success">Pay</button>
                </div>
            </div>
        </div>
    `;
    document.getElementById('modalsContainer').appendChild(paymentModal);
    $('#payment-modal').modal('show');

    // Handle the change event for the payment method select
    document.getElementById('paymentMethod').addEventListener('change', function () {
        const paymentMethod = this.value;
        if (paymentMethod === 'card') {
            document.getElementById('cardDetails').style.display = 'block';
        } else {
            document.getElementById('cardDetails').style.display = 'none';
        }
    });

    // Handle the click event for the Pay button
    document.getElementById('payButton').addEventListener('click', function () {
        const paymentMethod = document.getElementById('paymentMethod').value;
        if (paymentMethod === 'card') {
            const cardDigits = document.getElementById('cardDigits').value;
            if (cardDigits.length === 4) {
                console.log('Payment method: Card');
                console.log('Last 4 digits of the card: ' + cardDigits);
                console.log('done');
                $('#payment-modal').modal('hide');
            } else {
                alert('Please enter the last 4 digits of your card.');
            }
        } else {
            console.log('Payment method: Cash');
            console.log('done');
            $('#payment-modal').modal('hide');
        }
    });
});