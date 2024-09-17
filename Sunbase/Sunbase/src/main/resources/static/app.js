
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
  
});

function editCustomer(id) {
    // Implement edit functionality
}

function deleteCustomer(id) {
    // Implement delete functionality
}
