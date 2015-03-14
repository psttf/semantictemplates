_на данный момент пример не работает_

Пример состоит из:

  * [файла онтологии](http://code.google.com/p/semantictemplates/source/browse/src/main/resources/ontology.owl?repo=example);
  * [файла с данными](http://code.google.com/p/semantictemplates/source/browse/src/main/resources/data.rdf?repo=example);
  * приложения, использующего шаблоны для генерации текстового представления данных на основе онтологии, основной код содержится в файле по [данной ссылке](http://code.google.com/p/semantictemplates/source/browse/src/main/scala/org/purl/psnet/semanticWebApp/templates/App.scala?repo=example).

Для запуска примера слудует загрузить код приложения и из корневой папки выполнить команду
```
mvn scala:run -DmainClass=org.purl.psnet.semanticWebApp.templates.App -DaddArgs="-uri:<URI>"
```

Где `<URI>` — URI объекта, который требуется преобразовать (рекомендуется использовать `http://www.example.org#Vanya`, `http://www.example.org#Vasya` или `http://www.example.org#Petya`). Результат преобразования записывается в файл `out.txt`.