/**
 * 
 */
// JavaScript, um den Warenkorb anzuzeigen/auszublenden
document.addEventListener('DOMContentLoaded', function () {

const cartContainer = document.getElementById("cart-container");
const cartIcon = document.getElementById("cart-icon");
const cartIcon2 = document.getElementById("cart-icon2");

cartIcon.addEventListener("click", () => {
    if (cartContainer.style.display === "block") {
        cartContainer.style.display = "none"; // Warenkorb ausblenden
    } else {
        cartContainer.style.display = "block"; // Warenkorb anzeigen
    }
});
cartIcon2.addEventListener("click", () => {
    if (cartContainer.style.display === "block") {
        cartContainer.style.display = "none"; // Warenkorb ausblenden
    } else {
        cartContainer.style.display = "block"; // Warenkorb anzeigen
    }
});
});