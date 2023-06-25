// Получаем ссылки на все кнопки
var buttons = document.getElementsByTagName("button");

// Добавляем обработчик клика для каждой кнопки
for (var i = 0; i < buttons.length; i++) {
    buttons[i].addEventListener("click", addToCart);
}

// Функция обработчика клика
function addToCart() {
    // Получаем родительский элемент кнопки (li)
    var listItem = this.parentNode;

    // Получаем значения элементов li (название и описание товара)
    var productName = listItem.getElementsByTagName("h3")[0].textContent;
    var productDescription = listItem.getElementsByTagName("p")[0].textContent;

    // Создаем объект товара
    var product = {
        name: productName,
        description: productDescription
    };

    // Выполняем дополнительные действия при добавлении товара в корзину
    // Например, можно отправить данные на сервер или обновить интерфейс

    // Выводим сообщение об успешном добавлении товара
    alert("Товар '" + product.name + "' добавлен в корзину!");
}
