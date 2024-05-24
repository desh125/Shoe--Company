document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form");
    form.addEventListener("submit", function(event) {
        event.preventDefault();

        const fullName = document.querySelector('input[placeholder="Full Name"]').value;
        const lastName = document.querySelector('input[placeholder="Last Name"]').value;
        const email = document.querySelector('input[placeholder="Email"]').value;
        const phone = document.querySelector('input[placeholder="Phone No."]').value;
        const password = document.querySelector('input[placeholder="Password"]').value;
        const confirmPassword = document.querySelector('input[placeholder="Confirm Password"]').value;

        if (password !== confirmPassword) {
            alert("Passwords do not match!");
            return;
        }

        const user = {
            fullName: fullName,
            lastName: lastName,
            email: email,
            phone: phone,
            password: password
        };

        fetch("http://localhost:8080/data/user", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        })
            .then(response => {
                if (response.ok) {
                    alert("User registered successfully!");
                    window.location.href = "auth-sign-in.html";
                } else {
                    response.json().then(data => {
                        alert(`Error: ${data.message}`);
                    });
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("An error occurred while registering the user.");
            });
    });
});
