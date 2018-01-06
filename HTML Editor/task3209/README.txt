taskKey="com.javarush.task.task32.task3209.big24"

HTML Editor (24)

Твой html редактор готов!
Ты научился:
- Создавать приложения с графическим интерфейсом.
- Работать с диалоговыми окнами.
- Пользоваться классами из библиотеки Swing.
- Реализовывать взаимодействие компонентов программы с помощью событий, слушателей,
действий.
- Усилил свои знания в области MVC.

Что можно улучшить в разработанном редакторе:
- Добавить панель инструментов, повторяющую функционал меню.
- Добавить подсветку html тегов на второй вкладке.
- Добавить возможность загрузки документа из Интернет.
- Расширить возможности редактора (вставка картинки, ссылки и т.д.)

Поздравляю, так держать!


Требования:
1.	html редактор готов!


HTML Editor (23)

23.1.	Напишем метод для сохранения открытого файла saveDocument(). Метод должен
работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а
использовать currentFile. Если currentFile равен null, то вызывать метод saveDocumentAs().
23.2.	Пришло время реализовать метод openDocument(). Метод должен работать
аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла.
Подсказка: Обрати внимание на имя метода для показа диалогового окна.
Когда файл выбран, необходимо:
23.2.1.	Установить новое значение currentFile.
23.2.2.	Сбросить документ.
23.2.3.	Установить имя файла в заголовок у представления.
23.2.4.	Создать FileReader, используя currentFile.
23.2.5.	Вычитать данные из FileReader-а в документ document с помощью объекта класса
HTMLEditorKit.
23.2.6.	Сбросить правки (вызвать метод resetUndo представления).
23.2.7.	Если возникнут исключения - залогируй их и не пробрасывай наружу.
Проверь работу пунктов меню Сохранить и Открыть.



HTML Editor (22)

Реализуем в контроллере метод для сохранения файла под новым именем saveDocumentAs().
Реализация должна:
22.1.	Переключать представление на html вкладку.
22.2.	Создавать новый объект для выбора файла JFileChooser.
22.3.	Устанавливать ему в качестве фильтра объект HTMLFileFilter.
22.4.	Показывать диалоговое окно "Save File" для выбора файла.
22.5.	Если пользователь подтвердит выбор файла:
22.5.1.	Сохранять выбранный файл в поле currentFile.
22.5.2.	Устанавливать имя файла в качестве заголовка окна представления.
22.5.3.	Создавать FileWriter на базе currentFile.
22.5.4.	Переписывать данные из документа document в объекта FileWriter-а аналогично тому,
как мы это делали в методе getPlainText().
22.6.	Метод не должен кидать исключения.
Проверь работу пункта меню Сохранить как...



HTML Editor (21)

Для открытия или сохранения файла мы будем использовать JFileChooser из библиотеки swing.
Объекты этого типа поддерживают фильтры, унаследованные от FileFilter. Сейчас мы напишем
свой фильтр:
21.1.	Создай публичный класс HTMLFileFilter унаследованный от FileFilter.
21.2.	Мы хотим, чтобы окно выбора файла отображало только html/htm файлы или папки.
Переопредели метод accept(File file), чтобы он возвращал true, если переданный файл
директория или содержит в конце имени ".html" или ".htm" без учета регистра.
21.3.	Чтобы в окне выбора файла в описании доступных типов файлов отображался текст
"HTML и HTM файлы" переопредели соответствующим образом метод getDescription().



HTML Editor (20)

20.1.	Реализуй метод создания нового документа createNewDocument() в контроллере. Он
должен:
20.1.1.	Выбирать html вкладку у представления.
20.1.2.	Сбрасывать текущий документ.
20.1.3.	Устанавливать новый заголовок окна, например: "HTML редактор". Воспользуйся
методом setTitle(), который унаследован в нашем представлении.
20.1.4.	Сбрасывать правки в Undo менеджере. Используй метод resetUndo представления.
20.1.5. Обнулить переменную currentFile.
20.2.	Реализуй метод инициализации init() контроллера. Он должен просто вызывать метод
создания нового документа.
Проверь работу пункта меню Новый.



HTML Editor (19)

Реализуем метод actionPerformed(ActionEvent actionEvent) у представления, этот метод
наследуется от интерфейса ActionListener и будет вызваться при выборе пунктов меню, у
которых наше представление указано в виде слушателя событий.
19.1.	Получи из события команду с помощью метода getActionCommand(). Это будет
обычная строка. По этой строке ты можешь понять какой пункт меню создал данное
событие.
19.2.	Если это команда "Новый", вызови у контроллера метод createNewDocument(). В этом
пункте и далее, если необходимого метода в контроллере еще нет - создай заглушки.
19.3.	Если это команда "Открыть", вызови метод openDocument().
19.4.	Если "Сохранить", то вызови saveDocument().
19.5.	Если "Сохранить как..." - saveDocumentAs().
19.6.	Если "Выход" - exit().
19.7.	Если "О программе", то вызови метод showAbout() у представления.
Проверь, что заработали пункты меню Выход и О программе.



