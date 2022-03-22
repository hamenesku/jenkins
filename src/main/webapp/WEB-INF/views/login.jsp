<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <div class="col-md-8 col-lg-7 col-xl-6">
                  <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg" class="img-fluid" alt="Phone image">
                </div>
                <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                  <div class="card card-item">
                      <div class="card-body">
                        <form method="post"><!-- action="/user/access" -->

                            <h2 class="text-center">LogIn</h2>
                            <div class="d-flex justify-content-center">
                                <hr class="w-75 mb-5">
                            </div>
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <!-- <label class="form-label" for="form1Example13">User</label> -->
                              <input type="text" id="form1Example13" name="username" placeholder="User" class="text-center form-control form-control-lg" />
                            </div>
                  
                            <!-- Password input -->
                            <div class="form-outline mb-4">
                                <!-- <label class="form-label" for="form1Example23">Password</label> -->
                              <input type="password" id="form1Example23" name="password" placeholder="Password" class="text-center form-control form-control-lg" />
                            </div>

                  
                            <!-- <div class="d-flex justify-content-around align-items-center mb-4">
                              
                              <div class="form-check">
                                <input
                                  class="form-check-input"
                                  type="checkbox"
                                  value=""
                                  id="form1Example3"
                                  checked
                                />
                                <label class="form-check-label" for="form1Example3"> Remember me </label>
                              </div>
                              <a href="#!">Forgot password?</a>
                            </div> -->
                  
                            <!-- Submit button -->
                            <div class="col-4 offset-4">
                                <button type="submit" class="btn btn-primary btn-lg btn-block w-100">LogIn</button>
                            </div>
                            <p class="w-100 text-center my-3">
                                Dont have an account? <a href="/user/register">Sign up</a>
                            </p>
                
        
                          </form>
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