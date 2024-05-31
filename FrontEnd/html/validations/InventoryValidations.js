document.addEventListener('DOMContentLoaded', (event) => {
    const form = document.getElementById('inventory-form');

    form.addEventListener('submit', function (e) {
        e.preventDefault(); // Prevent form submission

        // Validate the form
        if (validateForm()) {
            form.submit(); // Submit the form if validation passes
        }
    });

    function validateForm() {
        let isValid = true;

        // Get all the form fields
        const itemPicture = document.getElementById('file-2');
        const itemCode = document.getElementById('itemCode');
        const description = document.getElementById('description');
        const supplierNames = document.getElementById('supplierNames');
        const category = document.getElementById('category');
        const size = document.getElementById('size');
        const buyingPrice = document.getElementById('buyingPrice');
        const salePrice = document.getElementById('salePrice');
        const expectProfit = document.getElementById('expectProfit');
        const profitMargin = document.getElementById('profitMargin');
        const qty = document.getElementById('qty');
        const status = document.getElementById('status');

        // Simple regex pattern for validation
        const pricePattern = /^[0-9]+(\.[0-9]{1,2})?$/;

        // Helper function to show error messages
        function showError(input, message) {
            const formGroup = input.closest('.form-group');
            const helpBlock = formGroup.querySelector('.help-block');
            helpBlock.textContent = message;
            helpBlock.style.color = 'red';
            isValid = false;
        }

        // Helper function to clear error messages
        function clearError(input) {
            const formGroup = input.closest('.form-group');
            const helpBlock = formGroup.querySelector('.help-block');
            helpBlock.textContent = '';
        }

        // Validate required fields
        if (!itemPicture.files.length) {
            showError(itemPicture, 'Item Picture is required');
        } else {
            clearError(itemPicture);
        }

        if (itemCode.value.trim() === '') {
            showError(itemCode, 'Item Code is required');
        } else {
            clearError(itemCode);
        }

        if (description.value.trim() === '') {
            showError(description, 'Description is required');
        } else {
            clearError(description);
        }

        if (supplierNames.value.trim() === '') {
            showError(supplierNames, 'Supplier is required');
        } else {
            clearError(supplierNames);
        }

        if (category.value.trim() === '') {
            showError(category, 'Category is required');
        } else {
            clearError(category);
        }

        if (size.value.trim() === '') {
            showError(size, 'Size is required');
        } else {
            clearError(size);
        }

        if (buyingPrice.value.trim() === '' || !pricePattern.test(buyingPrice.value.trim())) {
            showError(buyingPrice, 'A valid Buying Price is required');
        } else {
            clearError(buyingPrice);
        }

        if (salePrice.value.trim() === '' || !pricePattern.test(salePrice.value.trim())) {
            showError(salePrice, 'A valid Sale Price is required');
        } else {
            clearError(salePrice);
        }

        if (expectProfit.value.trim() === '' || !pricePattern.test(expectProfit.value.trim())) {
            showError(expectProfit, 'A valid Expected Profit is required');
        } else {
            clearError(expectProfit);
        }

        if (profitMargin.value.trim() === '' || !pricePattern.test(profitMargin.value.trim())) {
            showError(profitMargin, 'A valid Profit Margin is required');
        } else {
            clearError(profitMargin);
        }

        if (qty.value.trim() === '' || isNaN(qty.value) || parseInt(qty.value) <= 0) {
            showError(qty, 'A valid Quantity is required');
        } else {
            clearError(qty);
        }

        if (status.value.trim() === '') {
            showError(status, 'Status is required');
        } else {
            clearError(status);
        }

        return isValid;
    }
});
