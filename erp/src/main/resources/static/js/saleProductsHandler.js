document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('addProductBtn').addEventListener('click', function() {
        var productSelect = document.getElementById('productSelect');
        var selectedProduct = productSelect.options[productSelect.selectedIndex];
        var productId = selectedProduct.value;
        var productName = selectedProduct.text;

        // Aquí añadir la lógica para agregar la fila a la tabla
        // Esto es  un ejemplo
        var table = document.getElementById('selectedProductsTable').getElementsByTagName('tbody')[0];
        var newRow = table.insertRow();
        var cell1 = newRow.insertCell(0);
        var cell2 = newRow.insertCell(1);
        cell1.innerHTML = productName;
        cell2.innerHTML = '<input type="hidden" name="productIds" value="' + productId + '">';
    });
});
