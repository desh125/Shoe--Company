document.addEventListener('DOMContentLoaded', (event) => {
    const form = document.getElementById('customer-form');

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
        const customerCode = document.getElementById('customerCode');
        const name = document.getElementById('name');
        const gender = document.getElementById('gender');
        const contactNo = document.getElementById('contactNo');
        const email = document.getElementById('email');
        const dateOfBirth = document.getElementById('dateOfBirth');
        const addressLine1 = document.getElementById('addressLine1');
        const addressLine2 = document.getElementById('addressLine2');
        const addressLine3 = document.getElementById('addressLine3');
        const addressLine4 = document.getElementById('addressLine4');
        const addressLine5 = document.getElementById('addressLine5');
        const level = document.getElementById('level');
        const totalPoints = document.getElementById('totalPoints');

        // Simple regex patterns for validation
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        const phonePattern = /^[0-9]{10,15}$/;

        // Helper function to show error messages
        function showError(input, message) {
            const formGroup = input.parentElement;
            const helpBlock = formGroup.querySelector('.help-block');
            helpBlock.textContent = message;
            helpBlock.style.color = 'red';
            isValid = false;
        }

        // Helper function to clear error messages
        function clearError(input) {
            const formGroup = input.parentElement;
            const helpBlock = formGroup.querySelector('.help-block');
            helpBlock.textContent = '';
        }

        // Validate required fields
        if (customerCode.value.trim() === '') {
            showError(customerCode, 'Customer Code is required');
        } else {
            clearError(customerCode);
        }

        if (name.value.trim() === '') {
            showError(name, 'Customer Name is required');
        } else {
            clearError(name);
        }

        if (gender.value.trim() === '') {
            showError(gender, 'Gender is required');
        } else {
            clearError(gender);
        }

        if (contactNo.value.trim() === '' || !phonePattern.test(contactNo.value.trim())) {
            showError(contactNo, 'A valid Phone Number is required');
        } else {
            clearError(contactNo);
        }

        if (email.value.trim() === '' || !emailPattern.test(email.value.trim())) {
            showError(email, 'A valid Email is required');
        } else {
            clearError(email);
        }

        if (dateOfBirth.value.trim() === '') {
            showError(dateOfBirth, 'Date of Birth is required');
        } else {
            clearError(dateOfBirth);
        }

        if (addressLine1.value.trim() === '') {
            showError(addressLine1, 'Address Line 1 is required');
        } else {
            clearError(addressLine1);
        }

        if (addressLine2.value.trim() === '') {
            showError(addressLine2, 'Address Line 2 is required');
        } else {
            clearError(addressLine2);
        }

        if (addressLine3.value.trim() === '') {
            showError(addressLine3, 'Address Line 3 is required');
        } else {
            clearError(addressLine3);
        }

        if (addressLine4.value.trim() === '') {
            showError(addressLine4, 'Address Line 4 is required');
        } else {
            clearError(addressLine4);
        }

        if (addressLine5.value.trim() === '') {
            showError(addressLine5, 'Address Line 5 is required');
        } else {
            clearError(addressLine5);
        }

        if (level.value.trim() === '') {
            showError(level, 'Level is required');
        } else {
            clearError(level);
        }

        if (totalPoints.value.trim() === '' || isNaN(totalPoints.value) || parseInt(totalPoints.value) < 0) {
            showError(totalPoints, 'Valid Points are required');
        } else {
            clearError(totalPoints);
        }

        return isValid;
    }
});
