<html>
<head>
    <title>File Upload Test</title>
</head>
<body>
<h1>FileUpload 테스트</h1>
<form action="fileUploadTest" method="post" enctype="multipart/form-data">
    작성자<input type="text" name="fileWriter"><br>
    파일<input type="file" name="fileName"><br>
    파일설명<br/><textarea name="fileDescription" rows="5" cols="30"></textarea><br/><br/>
    <input type="submit" value="업로드">
</form>
</body>
</html>