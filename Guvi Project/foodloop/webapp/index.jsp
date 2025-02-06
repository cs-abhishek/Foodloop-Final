<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodLoop - Home</title>
    <!-- Link to Bootstrap CSS for styling -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Welcome to FoodLoop</h1>
        <p class="lead text-center">Helping reduce food wastage by connecting donors with charities and delivery personnel.</p>

        <!-- Buttons linking to different modules of the system -->
        <div class="row justify-content-center mt-4">
            <div class="col-md-3">
                <a href="user" class="btn btn-primary btn-lg btn-block">I Want to Donate Food</a>
            </div>
            <div class="col-md-3">
                <a href="admin" class="btn btn-secondary btn-lg btn-block">Admin Portal</a>
            </div>
            <div class="col-md-3">
                <a href="delivery" class="btn btn-success btn-lg btn-block">Delivery Person Login</a>
            </div>
        </div>

        <div class="text-center mt-4">
            <h3>How it Works</h3>
            <p>FoodLoop connects people who have extra food with NGOs and charities who need it. Delivery personnel help transport the food to its destination.</p>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
