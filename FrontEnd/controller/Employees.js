
function submitEmployee() {
    console.log("clicked");
    var employeeData = {
        employeeCode: document.getElementById("employeeCode").value,
        employeeName: document.getElementById("employeeName").value,
        gender: document.getElementById("gender").value,
        status: document.getElementById("status").value,
        designation: document.getElementById("designation").value,
        accessRole: document.getElementById("accessRole").value,
        dob: document.getElementById("dob").value,
        dateOfJoin: document.getElementById("dateOfJoin").value,
        attachedBranch: document.getElementById("attachedBranch").value,
        addressLine01: document.getElementById("addressLine01").value,
        addressLine02: document.getElementById("addressLine02").value,
        addressLine03: document.getElementById("addressLine03").value,
        addressLine04: document.getElementById("addressLine04").value,
        addressLine05: document.getElementById("addressLine05").value,
        contactNo: document.getElementById("contactNo").value,
        email: document.getElementById("email").value,
        emergencyContact: document.getElementById("emergencyContact").value
    };
    console.log("first")
    const jsonObject = JSON.stringify(employeeData);
    $.ajax({
        url: "http://localhost:8080/app/api/v1/employees", // Corrected endpoint
        method: "POST",
        data: jsonObject,
        contentType: "application/json",
        success: function (resp, textStatus, jqxhr) {
            console.log("Success", resp);
            if (jqxhr.status == 201) {
                alert("Added employee successfully");
            }
        },
        error: function (jqxhr, textStatus, error) {
            console.log("error: ", jqxhr);
            console.log("error: ", textStatus);
            console.log("error: ", error);
        }
    });
    console.log("second")

}

// Function to retrieve all customers
// Function to retrieve all employees using AJAX
function getAllEmployees() {
    // Make an AJAX GET request to retrieve all employees
    $.ajax({
        type: "GET",
        url: "/employees",
        success: function (data) {
            // Display the list of employees
            displayEmployees(data);
        },
        error: function (error) {
            alert("Error retrieving employees: " + error.responseJSON.message);
        }
    });
}

// Function to display employees in a table or list
function displayEmployees(employees) {
    // Get the container element where the employee cards will be displayed
    var container = document.getElementById("employeeContainer");

    // Clear the container before adding new employee cards
    container.innerHTML = "";

    // Iterate through the list of employees and create a card for each employee
    employees.forEach(function (employee) {
        // Create card element
        var card = document.createElement("div");
        card.classList.add("col-lg-6");

        var cardContent = `
            <div class="card m-b-30">
                <div class="card-body py-5">
                    <div class="row">
                        <div class="col-lg-3 text-center">
                            <img src="data:image/png;base64,${employee.profilePic}" class="img-fluid mb-3" alt="${employee.employeeName}" />
                        </div>
                        <div class="col-lg-9">
                            <h4>Employee Details</h4>
                            <table class="table table-borderless mb-0">
                                <tbody>
                                    <tr>
                                        <th scope="row" class="p-1">Employee Code:</th>
                                        <td class="p-1">${employee.employeeCode}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Employee Name:</th>
                                        <td class="p-1">${employee.employeeName}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Gender:</th>
                                        <td class="p-1">${employee.gender}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Civil Status:</th>
                                        <td class="p-1">${employee.status}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Designation:</th>
                                        <td class="p-1">${employee.designation}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Access Role:</th>
                                        <td class="p-1">${employee.accessRole}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Date of Birth:</th>
                                        <td class="p-1">${employee.dob}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Date of Join:</th>
                                        <td class="p-1">${employee.dateOfJoin}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Branch:</th>
                                        <td class="p-1">${employee.attachedBranch}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Address:</th>
                                        <td class="p-1">
                                            ${employee.addressLine01},<br>
                                            ${employee.addressLine02},<br>
                                            ${employee.addressLine03},<br>
                                            ${employee.addressLine04},<br>
                                            ${employee.addressLine05}
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Contact No.:</th>
                                        <td class="p-1">${employee.contactNo}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Email:</th>
                                        <td class="p-1">${employee.email}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="p-1">Emergency Contact:</th>
                                        <td class="p-1">${employee.emergencyContact}</td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="button-list mt-4 mb-3">
                                <button type="button" class="btn btn-primary-rgba"><i class="feather icon-message-square mr-2"></i>Message</button>
                                <button type="button" class="btn btn-success-rgba"><i class="feather icon-phone mr-2" onclick="deleteCustomer()"></i>Delete</button>
                                <!-- Add an edit button -->
                                <button type="button" class="btn btn-info" onclick="openEditModal(${JSON.stringify(employee)})">Edit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `;

        // Set the card content
        card.innerHTML = cardContent;

        // Append card to container
        container.appendChild(card);
    });
}

// Call the getAllEmployees function when the page loads
/*$(document).ready(function () {
   // getAllEmployees();
});*/

// Function to open edit modal with employee details
function openEditModal(employee) {
    // Populate modal fields with employee details
    document.getElementById("editEmployeeCode").value = employee.employeeCode;
    document.getElementById("editEmployeeName").value = employee.employeeName;
    document.getElementById("editGender").value = employee.gender;
    document.getElementById("editStatus").value = employee.status;
    document.getElementById("editDesignation").value = employee.designation;
    document.getElementById("editAccessRole").value = employee.accessRole;
    document.getElementById("editDOB").value = employee.dob;
    document.getElementById("editDateOfJoin").value = employee.dateOfJoin;
    document.getElementById("editAttachedBranch").value = employee.attachedBranch;
    document.getElementById("editAddressLine01").value = employee.addressLine01;
    document.getElementById("editAddressLine02").value = employee.addressLine02;
    document.getElementById("editAddressLine03").value = employee.addressLine03;
    document.getElementById("editAddressLine04").value = employee.addressLine04;
    document.getElementById("editAddressLine05").value = employee.addressLine05;
    document.getElementById("editContactNo").value = employee.contactNo;
    document.getElementById("editEmail").value = employee.email;
    document.getElementById("editEmergencyContact").value = employee.emergencyContact;

    // Show the edit modal
    $('#editModal').modal('show');
}


// Function to delete a customer by ID
function deleteCustomer(customerId) {
    // Make an AJAX DELETE request to delete the customer by ID
    $.ajax({
        type: "DELETE",
        url: "/customers/" + customerId,
        success: function (data) {
            alert("Customer deleted successfully!");
            // Refresh the customer list after deletion
            getAllCustomers();
        },
        error: function (error) {
            alert("Error deleting customer: " + error.responseJSON.message);
        }
    });
}

// Function to update a customer by ID
function updateCustomer(customerId) {
    var updatedCustomerData = {
        name: document.getElementById("updatedCustomerName").value,
        gender: document.getElementById("updatedGender").value,
        // Add other fields as needed
    };

    // Make an AJAX PUT request to update the customer by ID
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/customers/" + customerId,
        data: JSON.stringify(updatedCustomerData),
        success: function (data) {
            alert("Customer updated successfully!");
            // Refresh the customer list after update
            getAllCustomers();
        },
        error: function (error) {
            alert("Error updating customer: " + error.responseJSON.message);
        }
    });
}

// Function to clear the form after submission
function clearForm() {
    document.getElementById("customerName").value = "";
    document.getElementById("gender").value = "";
    // Clear other fields as needed
}
