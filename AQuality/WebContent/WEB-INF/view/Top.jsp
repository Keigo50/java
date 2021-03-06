<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="dao.AQualityDAO" %>
<%@page import="dto.AllDto" %>
<%@page import="java.util.ArrayList" %>
<%ArrayList<AllDto> result = (ArrayList<AllDto>)request.getAttribute("result");%>

<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link rel="stylesheet" href="reset.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css" />
    <title>AQuality</title>
</head>

<body>
    <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
    <header>
        <div class="header">
              <img src="./keigo8.svg" width="200px" height="40px" alt="logo" />
            <nav class="nav">
                <div class="nav-header">
                    <button type="button" id="btnvalue">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>


                <div id="gnavi">
                    <ul class="dropdown">
                        <li><a href="ShowServlet"><span class="glyphicon glyphicon-home"> HOME</span></a></li>
                        <li><a href="IncomeInsert">収入入力</a></li>
                        <li><a href="SpendingInsert">支出入力</a></li>
                    </ul>
                </div>
            </nav>
            <ul id="pc_menu">
                <li class="header_menu"><a href="ShowServlet"><span class="glyphicon glyphicon-home"> HOME</span>
                    </a></li>
                <li class="header_menu"><a href="IncomeInsert">収入入力</a></li>
                <li class="header_menu"><a href="SpendingInsert">支出入力</a></li>
            </ul>
        </div>

    </header>


    <div class="main">
        <div class="main_content">
            <div class="main_date">
                今日の日付<br />
                <div id="date"></div>
            </div>
            <div class="main_list">
                <ul class="nav nav-tabs" id="tab">
                    <li class="active"><a href="ShowServlet">収入・支出</a></li>
                    <li><a href="Income">収入</a></li>
                    <li><a href="Spending">支出</a></li>
                </ul>
                <label>
                    <select name=select onchange="outputSelectedValueAndText(this);" id="select">
                        <option value="収入・支出">収入・支出</option>
                        <option value="収入">収入</option>
                        <option value="支出">支出</option>
                    </select>
                </label>
            </div>
            <div class="main_items">
                <button class="items">
                    ID
                </button>
                <button class="items">
                    日付
                </button>
                <button class="items">
                    カテゴリ
                </button>
                <button class="items">
                    品目名
                </button>
                <button class="items">
                    金額
                </button>
                <button class="items">
                    入金先
                </button>
                <button class="items">
                    支払元
                </button>
                <button class="items">
                    お店の名前
                </button>
                <button class="items">
                    メモ
                </button>
                <button class="items"></button>
                <button class="items"></button>
                <button class="items"></button>
            </div>
            <div class="main_table">
                <table border="1" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>種別</th>
                            <th>日付</th>
                            <th>カテゴリ</th>
                            <th>品目名</th>
                            <th>金額</th>
                            <th>入金先</th>
                            <th>支払元</th>
                            <th>お店の名前</th>
                            <th>メモ</th>
                        </tr>
                    </thead>
                    <tbody>
                     <%ArrayList<AllDto> data = AQualityDAO.searchAll();%>
                        <!-- データベースに入っているデータ数を格納-->
                        <%for(int i = 0;i < data.size();i++){ %>
                        <% AllDto all = (AllDto) request.getAttribute("Aquality" + (i + 1));%>
                        <tr>
                            <td>
                                <%=all.getType() %>
                            </td>
                            <td>
                                <%=all.getDate()%>
                            </td>
                            <td>

                                <%=all.getCategory()%>
                            </td>
                            <td>
                                <%=all.getName()%>
                            </td>
                            <td>
                                <%=all.getMoney() %>
                            </td>
                            <td>
                                <%=all.getPayment_source() %>
                            </td>

                            <td>
                                <%=all.getPayment_destination() %>
                            </td>
                            <td>
                                <%=all.getStore_name() %>
                            </td>
                            <td>
                                <%=all.getMemo() %>
                            </td>
                        </tr>
                        <%} %>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <footer>

        <div class="footer">
            <small>&copy; keigo satou 2018</small>
        </div>
    </footer>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

    <!-- Bootstrap JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src=./script.js> </script> </body> </html>
