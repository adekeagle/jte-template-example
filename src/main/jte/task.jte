@param java.util.List<pl.adcom.jte_template_example.Task> taskList

<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tasks</title>
    <link rel="stylesheet" href="./css/style.css">
    <script src="./js/script.js"></script>
</head>
<body>

<%--<form action="/add" method="get">--%>
<%--    @for(pl.adcom.jte_template_example.Task task : taskList)--%>

<%--        @if(task.getIsDone() == true)--%>
<%--            <input type="checkbox" onchange="toggleTaskStatus(${task.getId()})" checked>--%>
<%--            <s>${task.getName()}</s>--%>
<%--        @else--%>
<%--            <input type="checkbox" onchange="toggleTaskStatus(${task.getId()})">--%>
<%--            ${task.getName()}--%>
<%--        @endif--%>

<%--        <br>--%>
<%--    @endfor--%>

<%--    <input type="submit" value="Dodaj zadanie">--%>
<%--</form>--%>

    <div class="container">
        <h1>Lista Zadań</h1>
        <form action="/add" method="post">
            <div class="task-list">
                @for(pl.adcom.jte_template_example.Task task : taskList)
                    <div class="task-item">
                                @if(task.getIsDone() == true)
                                    <input type="checkbox" onchange="toggleTaskStatus(${task.getId()})" checked>
                                    <s>${task.getName()}</s>
                                @else
                                    <input type="checkbox" onchange="toggleTaskStatus(${task.getId()})">
                                    ${task.getName()}
                                @endif
                    </div>
                @endfor
            </div>
            <input class="submit-button" type="submit" value="Dodaj zadanie">
        </form>
    </div>

</body>
</html>