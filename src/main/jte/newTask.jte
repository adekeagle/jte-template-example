@param pl.adcom.jte_template_example.Task task
<%--@param boolean isDone--%>

<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<%--    <h1>Dodaj zadanko</h1>--%>
<%--    <form action="/tasks" method="post">--%>
<%--        <label for="id">Id</label>--%>
<%--        <input type="text" name="id" id="id" required>--%>
<%--        <label for="name">Task name:</label>--%>
<%--        <input type="text" name="name" id="name" required>--%>
<%--        <label for="isDone">Is Done</label>--%>
<%--        <input type="checkbox" name="isDone" id="isDone" value="true">--%>

<%--        <input type="submit" value="Dodaj zadanie">--%>
<%--    </form>--%>

        <div class="container">
            <h1>Dodaj Zadanie</h1>
            <div class="task-item">
            <form action="/tasks" method="post">
                <div class="form-group">
                    <label for="id">Id:</label>
                    <input type="text" name="id" id="id" required>
                </div>
                <div class="form-group">
                    <label for="name">Nazwa zadania:</label>
                    <input type="text" name="name" id="name" required>
                </div>
                <div class="form-group">
                    <label for="isDone">Czy zakończone:</label>
                    <input type="checkbox" name="isDone" id="isDone" value="true">
                </div>
                <div>
                    <input class="submit-button" type="submit" value="Dodaj zadanie">
                </div>
            </form>

            </div>
        </div>
</body>
</html>