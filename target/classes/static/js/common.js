/**
 * COMMON.JS - Các function dùng chung cho toàn bộ website
 * Tránh duplicate code trong nhiều file
 */

// ===== NOTIFICATION SYSTEM =====
const showNotification = (message, type) => {
    const notification = document.createElement('div');
    notification.className = `notification ${type}`;
    notification.textContent = message;
    notification.style.cssText = `
        position: fixed;
        top: 20px;
        right: 20px;
        padding: 15px 20px;
        border-radius: 5px;
        color: white;
        z-index: 9999;
        ${type === 'success' ? 'background-color: #4CAF50;' : 'background-color: #f44336;'}
    `;

    document.body.appendChild(notification);

    setTimeout(() => {
        notification.remove();
    }, 3000);
};

// ===== CART COUNTER UPDATE =====
const updateCartCounter = () => {
    fetch('/cart/count')
        .then(response => response.json())
        .then(data => {
            const cartCounter = document.getElementById('cart-counter');
            if (cartCounter) {
                cartCounter.textContent = data.count;
            }
        })
        .catch(error => console.error('Error updating cart counter:', error));
};

// ===== FORM VALIDATION HELPERS =====
const showFieldError = (field, message) => {
    field.classList.add('error');

    const existingError = field.parentNode.querySelector('.error-message');
    if (existingError) {
        existingError.remove();
    }

    const errorDiv = document.createElement('div');
    errorDiv.className = 'error-message';
    errorDiv.textContent = message;
    errorDiv.style.cssText = 'color: #f44336; font-size: 12px; margin-top: 5px;';
    field.parentNode.appendChild(errorDiv);
};

const clearFieldError = (field) => {
    field.classList.remove('error');
    const errorMessage = field.parentNode.querySelector('.error-message');
    if (errorMessage) {
        errorMessage.remove();
    }
};

const isValidEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
};

const isValidPhone = (phone) => {
    const phoneRegex = /^[0-9]{10,11}$/;
    return phoneRegex.test(phone.replace(/\s+/g, ''));
};

// ===== LOADING SPINNER =====
const showLoading = () => {
    const loading = document.createElement('div');
    loading.id = 'loading-spinner';
    loading.innerHTML = `
        <div style="
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: rgba(0,0,0,0.8);
            color: white;
            padding: 20px;
            border-radius: 5px;
            z-index: 10000;
        ">
            Đang xử lý...
        </div>
    `;
    document.body.appendChild(loading);
};

const hideLoading = () => {
    const loading = document.getElementById('loading-spinner');
    if (loading) {
        loading.remove();
    }
};

// ===== GLOBAL INITIALIZATION =====
document.addEventListener('DOMContentLoaded', () => {
    // Update cart counter on every page load
    updateCartCounter();

    // Add global error handler
    window.addEventListener('error', (e) => {
        console.error('Global error:', e.error);
    });
});
