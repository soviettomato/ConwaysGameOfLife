<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Game of life</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" media="screen" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customizing.css" media="screen" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/slider/css/slider.css" media="screen" >
</head>
<body onload="createTable()">
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-latest.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/slider/js/bootstrap-slider.js"></script>
    <script src="${pageContext.request.contextPath}/js/other/scripts.js"></script>

    <div class="row">
        <div id="table-div" class="span4">

        </div>

        <div class="span8">
            <div class="accordion" id="accordion2">
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                        Настройка поля
                    </a>
                </div>
                <div id="collapseOne" class="accordion-body collapse">
                    <div class="accordion-inner">
                        <p class="lead">Количество строк : </p>
                        <input id="countRows" size="12" type="number" value="10" oninput="createTable()">
                        <p class="lead">Количество столбцов : </p>
                        <input id="countColumns" size="12" type="number" value="10" oninput="createTable()">
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                        Начальное поколение
                    </a>
                </div>
                <div id="collapseTwo" class="accordion-body collapse">
                    <div class="accordion-inner">
                        <p class="lead">Количество особей : </p>
                        <input id="countOfPerson" size="12" type="number" value="40">
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                       Управление поколениями
                     </a>
                </div>
                <div id="collapseThree" class="accordion-body collapse">
                    <div class="accordion-inner">
                        <p>
                            <button id="buttonStart" class="btn btn-success" type="button">Старт</button>
                            <button id="buttonPause" class="btn btn-info" type="button">Пауза</button>
                        </p>
                        <p>
                            <button id="buttonSave" class="btn btn-success" type="button">Сохранить</button>
                            <button id="buttonClean" class="btn btn-danger" type="button">Очистить</button>
                        </p>
                        <p>
                            <button id="buttonForward" class="btn btn-primary">Шаг назад</button>
                            <button id="buttonBackward" class="btn btn-primary">Шаг вперед</button>
                        </p>
                        <p class="lead" >
                           Скорость
                        </p>
                        </div>
                    </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
                        База данных
                    </a>
                </div>
                <div id="collapseFour" class="accordion-body collapse">
                    <div class="accordion-inner">
                        Anim pariatur cliche...
                    </div>
                </div>
            </div>

        </div>
        </div>
    </div>

</body>
</html>

