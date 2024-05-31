document.addEventListener('DOMContentLoaded', (event) => {
    const form = document.getElementById('employee-form');

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
        const profilePicture = document.getElementById('file-1');
        const employeeCode = document.getElementById('employeeCode');
        const name = document.getElementById('name');
        const gender = document.getElementById('gender');
        const status = document.getElementById('status');
        const designation = document.getElementById('designation');
        const role = document.getElementById('role');
        const dateOfBirth = document.getElementById('dateOfBirth');
        const dateOfJoin = document.getElementById('dateOfJoin');
        const branch = document.getElementById('branch');
        const buildingNo = document.getElementById('buildingNo');
        const lane = document.getElementById('lane');
        const mainCity = document.getElementById('mainCity');
        const mainState = document.getElementById('mainState');
        const postalCode = document.getElementById('postalCode');
        const contactNo = document.getElementById('contactNo');
        const email = document.getElementById('email');
        const guardianName = document.getElementById('guardianName');
        const emergencyContactNo = document.getElementById('emergencyContactNo');

        // Simple regex patterns for validation
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        const phonePattern = /^[0-9]{10,15}$/;

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
        if (!profilePicture.files.length) {
            showError(profilePicture, 'Profile Picture is required');
        } else {
            clearError(profilePicture);
        }

        if (employeeCode.value.trim() === '') {
            showError(employeeCode, 'Employee Code is required');
        } else {
            clearError(employeeCode);
        }

        if (name.value.trim() === '') {
            showError(name, 'Employee Name is required');
        } else {
            clearError(name);
        }

        if (gender.value.trim() === '') {
            showError(gender, 'Gender is required');
        } else {
            clearError(gender);
        }

        if (status.value.trim() === '') {
            showError(status, 'Status is required');
        } else {
            clearError(status);
        }

        if (designation.value.trim() === '') {
            showError(designation, 'Designation is required');
        } else {
            clearError(designation);
        }

        if (role.value.trim() === '') {
            showError(role, 'Access Role is required');
        } else {
            clearError(role);
        }

        if (dateOfBirth.value.trim() === '') {
            showError(dateOfBirth, 'Date of Birth is required');
        } else {
            clearError(dateOfBirth);
        }

        if (dateOfJoin.value.trim() === '') {
            showError(dateOfJoin, 'Date of Join is required');
        } else {
            clearError(dateOfJoin);
        }

        if (branch.value.trim() === '') {
            showError(branch, 'Attached Branch is required');
        } else {
            clearError(branch);
        }

        if (buildingNo.value.trim() === '') {
            showError(buildingNo, 'Address Line 1 is required');
        } else {
            clearError(buildingNo);
        }

        if (lane.value.trim() === '') {
            showError(lane, 'Address Line 1 is required');
        } else {
            clearError(lane);
        }

        if (mainCity.value.trim() === '') {
            showError(mainCity, 'City is required');
        } else {
            clearError(mainCity);
        }

        if (mainState.value.trim() === '') {
            showError(mainState, 'Country is required');
        } else {
            clearError(mainState);
        }

        if (postalCode.value.trim() === '') {
            showError(postalCode, 'Postal Code is required');
        } else {
            clearError(postalCode);
        }

        if (contactNo.value.trim() === '' || !phonePattern.test(contactNo.value.trim())) {
            showError(contactNo, 'A valid Contact Number is required');
        } else {
            clearError(contactNo);
        }

        if (email.value.trim() === '' || !emailPattern.test(email.value.trim())) {
            showError(email, 'A valid Email is required');
        } else {
            clearError(email);
        }

        if (guardianName.value.trim() === '') {
            showError(guardianName, 'Emergency Contact is required');
        } else {
            clearError(guardianName);
        }

        if (emergencyContactNo.value.trim() === '' || !phonePattern.test(emergencyContactNo.value.trim())) {
            showError(emergencyContactNo, 'A valid Emergency Contact Number is required');
        } else {
            clearError(emergencyContactNo);
        }

        return isValid;
    }
});
