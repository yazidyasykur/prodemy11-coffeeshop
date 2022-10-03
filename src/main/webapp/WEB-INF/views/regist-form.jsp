<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
    <div class="regist-bg">
    <div class="container-sm">
        <div id="regist-form" class="w-50 position-absolute top-50 start-50 translate-middle">
            <h1>Create your account</h1>
            <form>
        <div class="mb-3 row">
            <label for="Email" class="col-sm-3">Nama Lengkap</label>
            <div class="col-sm-9">
              <input type="text" class="form-control" id="staticEmail">
            </div>
          </div>
          <div class="mb-4 row">
            <label for="Email" class="col-sm-3 col-form-label">Email</label>
            <div class="col-sm-9">
              <input type="text" class="form-control" id="staticEmail">
            </div>
          </div>
          <div class="mb-3 row">
            <label for="Email" class="col-sm-3 col-form-label">Username</label>
            <div class="col-sm-9">
              <input type="text" class="form-control" id="staticEmail">
            </div>
          </div>
          <div class="mb-3 row">
            <label for="Password" class="col-sm-3 col-form-label">Password</label>
            <div class="col-sm-9">
              <input type="password" class="form-control" id="inputPassword">
            </div>
          </div>
          <div class="mb-3 row">
            <label for="Password" class="col-sm-3 col-form-label">Re-type Password</label>
            <div class="col-sm-9">
              <input type="password" class="form-control" id="inputPassword">
            </div>
          </div>
          <div class="mb-3 row">
            <label class="col-sm-3 col-form-label" for="jenis-kelamin">Jenis Kelamin</label>
          <div class="form-check col-sm-9 mt-2">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
              Laki-laki
            </label>
            <div id="cewe"  class="form-check float-end">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                 Perempuan
                </label>
              </div> 
          </div>
        
          </div>

          
        <button id="reg-sub" type="submit" class="position-relative btn btn-primary">Submit</button>
      </form>
      </div>

    </div>
    
</div>


      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>