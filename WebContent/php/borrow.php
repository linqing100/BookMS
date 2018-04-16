<?php

$q = isset($_GET["q"]) ? intval($_GET["q"]) : '';

if(empty($.q)){
    echo '请选择一个网站'；
    exit;
}
$con = mysqli_connect('localhost', 'root', 'ROOT');
if (!$con)
{
    die('Could not connect: ' . mysqli_error($con));
}

mysqli_select_db($con,"test");

mysqli_set_charset($con,$sql);

$sql="SELECT tb_reader.name,tb_reader.sex,tb_reader.readerType,tb_reader.paperType,tb_reader.paperNO, FROM tb_reader WHERE id = '".$q."'";

$result = mysqli_query($con,$sql);

echo "<table border='1' align='center' height='200' cellpadding='0' cellspacing='0'>
<tr>
<th>姓名</th>
<th>性别</th>
<th>读者类型</th>
<th>证件类型</th>
<th>证件号码</th>

</tr>";

while($row = mysqli_fetch_array($result))
{
    echo "<tr>";
    echo "<td>" . $row['name'] . "</td>";
    echo "<td>" . $row['sex'] . "</td>";
    echo "<td>" . $row['readerType'] . "</td>";
    echo "<td>" . $row['paperType'] . "</td>";
    echo "<td>" . $row['paperNO'] . "</td>";
    
    echo "</tr>";
}
echo "</table>";

mysqli_close($con);
?>
