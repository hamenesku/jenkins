<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserRegister</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<body>
    <div class="container">
        <section class="vh-100">
            <div class="container py-5 h-100">
              <div class="row d-flex align-items-center justify-content-center h-100">
                <div class="col-md-12">
                  <div class="card card-item">
                      <div class="card-body">
                        <!-- ${lista} -->
                        
                        <table class="table">
                          <thead>
                            <tr>
                              <th scope="col">Id</th>
                              <th scope="col">Enabled</th>
                              <th scope="col">User</th>
                              <th scope="col">Role Id</th>
                              
                            </tr>
                          </thead>
                          <tbody>
                    
                            <c:forEach var="li" items="${lista}">
                              <a href="#">
                                <tr>
                                  <td>${li.id}</td>
                                  <td>${li.enabled}</td>
                                  <td>${li.user}</td>
                                  <td>${li.role.id}</td>
                                </tr>
                              </a>
                            </c:forEach>
                            

                          </tbody>
                        </table>
                      </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
    </div>


    

    <!-- <h2>Welcome ${userName}</h2>

    <p>Get Loggin: ${login}</p> -->
     
</body>
</html>