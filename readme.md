
Чтобы скачать с гитхаба проект запускаем команду:
```
git clone https://github.com/alma-iceee/eschool.git
```

Дальше заходим в папку eschool:
```
cd eschool
```
Проект использует PostrgreSQL (настройки дефолтные, но если нужно настроить зайдите в src/main/resources/application.properties и введите ваши конфигурации)

Нужно указать путь репозитория где вы хотите создать jar проекта в pom.xml:
```
<distributionManagement>
    <repository>
        <id>eschool</id>
        <url>file://path/to/repo</url>
    </repository>
</distributionManagement>
```
Чтобы развернуть проект вводим команду:
```
mvnw deploy
```
Я не смог настроить миграции у MyBatisa, из-за этого исключительно для миграций я использовал FlywayDB. Чтобы база данных создалось введите:
```
mvnw flyway:migrate
```
Наконец-то запускаем сервер командой:
```
mvnw spring-boot:run
```
После запуска сервера, заходим в браузере по адресу: http://locahost:8080

Видим форму логина, вводим admin и pass.

Сайт имеет 2 функции: добавления студента (в форме указываете имя, фамилию и группу ученика и нажимаем добавить студента) и удаление студента (кнопка удаления справа от студента).