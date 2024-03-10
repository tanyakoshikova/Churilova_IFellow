# language: ru

Функция: Проверка полей задачи TestSelenium

  Структура сценария: Открыть задачи TestSelenium
    Когда Авторизация пользователя "<login>" с паролем "<password>"
    Также Переход в задачу TestSelenium
    Тогда Отображение статуса задачи "ГОТОВО" и версии "Version 2.0"

    Примеры:
      | login | password  |
      | AT14  | Qwerty123 |