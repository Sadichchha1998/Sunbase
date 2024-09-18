
document.addEventListener('DOMContentLoaded', () => {
    const loginScreen = document.getElementById('login-screen');
    const customerListScreen = document.getElementById('customer-list-screen');
    const addCustomerScreen = document.getElementById('add-customer-screen');
    const loginForm = document.getElementById('login-form');
    const customerTableBody = document.getElementById('customer-table').querySelector('tbody');
    const addCustomerButton = document.getElementById('add-customer-button');
    const addCustomerForm = document.getElementById('add-customer-form');
    const syncButton = document.getElementById('sync-button');
    
    let token = '';

    loginForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        fetch('/authenticate', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        })
        .then(response => response.json())
        .then(data => {
            token = data.token;
            loginScreen.style.display = 'none';
            customerListScreen.style.display = 'block';
            loadCustomers();
        })
        .catch(error => console.error('Error:', error));
    });

    addCustomerButton.addEventListener('click', () => {
        customerListScreen.style.display = 'none';
        addCustomerScreen.style.display = 'block';
    });

    addCustomerForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const customer = {
            firstName: document.getElementById('first-name').value,
            lastName: document.getElementById('last-name').value,
            street: document.getElementById('street').value,
            address: document.getElementById('address').value,
            city: document.getElementById('city').value,
            state: document.getElementById('state').value,
            email: document.getElementById('email').value,
            phone: document.getElementById('phone').value
        };

        fetch('/api/customers', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify(customer)
        })
        .then(response => response.json())
        .then(data => {
            customerListScreen.style.display = 'block';
            addCustomerScreen.style.display = 'none';
            loadCustomers();
        })
        .catch(error => console.error('Error:', error));
    });

    syncButton.addEventListener('click', () => {
        fetch('/api/sync', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
        .then(response => {
            loadCustomers();
        })
        .catch(error => console.error('Error:', error));
    });

    function loadCustomers() {
        fetch('/api/customers', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
        .then(response => response.json())
        .then(data => {
            customerTableBody.innerHTML = '';
            data.content.forEach(customer => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.street}</td>
                    <td>${customer.address}</td>
                    <td>${customer.city}</td>
                    <td>${customer.state}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phone}</td>
                    <td>
                        <button onclick="editCustomer(${customer.id})">Edit</button>
                        <button onclick="deleteCustomer(${customer.id})">Delete</button>
                    </td>
                `;
                customerTableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error:', error));
    }
});

function editCustomer(id) {
    // Implement edit functionality
}

function deleteCustomer(id) {
    // Implement delete functionality
}
