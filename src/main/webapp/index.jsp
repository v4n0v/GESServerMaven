<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GlassExpress Homepage</title>
</head>
<body>
<%@page pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>


<div style="overflow: hidden; margin-right: 10px; ">
    <% String s = "BMW"; %>
    <div style="width: 1000%;">
        <div style="float: left; margin-right: 10px;">
            <form method="GET" action="\controller">
                <div>
                  <textarea rows="15" select.selectedIndex=0>
                     <%=s %>
                    </textarea>
                </div>
                <div>
                    <input type="submit" value="+"/>
                    <input type="submit" value="-"/>
                </div>
            </form>
            <select>
                <option value="Rock">Рок</option>
                <option value="Blues" selected>Блюз</option>
            </select>
        </div>
        <div style="float: left; margin-right: 10px; ">
            <form method="GET" action="\controller">
                <div>
                  <textarea rows="15">
                      ...
                       список моделей
                       ...
                    </textarea>
                </div>
                <div>
                    <input type="submit" value="+"/>
                    <input type="submit" value="-"/>
                </div>
            </form>
        </div>
        <div style="float: left;  ">
            <form method="GET" action="\controller">
                <div>
                  <textarea rows="15">
                      ...
                       список поколений
                       ...
                    </textarea>
                </div>
                <div>
                    <input type="submit" value="+"/>
                    <input type="submit" value="-"/>
                </div>
            </form>
        </div>
    </div>
</div>
<div style="float: left;height:300px; width:100pxmargin-right: 10px; ">
  <div style="height:20px; width:100px">
      <%=s %>
  </div>
    <div style="height:20px; width:100px">
        <%=s %>
    </div>
    <div style="height:20px; width:100px">
        <%=s %>
    </div>
</div>





</body>
</html>