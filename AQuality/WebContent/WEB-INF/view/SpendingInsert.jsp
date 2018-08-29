<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
            <img src="./keigo1.svg" width="200px" height="40px" alt="logo" />
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
            <form action="ResultSpending">


                <div class="form-group">
                    <label>品目名</label>
                    <input type="text" class="form-control" name="name">
                </div>

                <div class="form-group">
                    <label>金額</label>
                    <input type="text" class="form-control" placeholder="800" name="money" required>
                </div>

                <div class="form-group">
                    <label>カテゴリ</label>
                    <select class="form-control" name="category">
                        <option>食費</option>
                        <option>日用雑貨</option>
                        <option>交通</option>
                        <option>通信</option>
                        <option>水道・光熱</option>
                        <option>住まい</option>
                        <option>交際費</option>
                        <option>エンタメ</option>
                        <option>教育・教養</option>
                        <option>医療・保険</option>
                        <option>美容・衣服</option>
                        <option>クルマ</option>
                        <option>税金</option>
                        <option>大型出費</option>
                        <option>その他</option>
                    </select>
                </div>


                <div class="form-group">
                    <label>支出元</label>
                    <select class="form-control" name="payment_source" required>
                        <option></option>
                        <option>お財布</option>
                        <option>貯金</option>
                        <option>銀行</option>
                        <option>クレジットカード</option>
                        <option>SUICA</option>
                        <option>PASMO</option>
                        <option>その他</option>
                    </select>
                </div>


                <div class="form-group">
                    <label>日付</label>
                    <input type="text" class="form-control" name="date" placeholder="yyyy-mm-ss" required>
                </div>

                <div class="form-group">
                    <label>お店の名前</label>
                    <input type="text" class="form-control" name="store_name">
                </div>


                <div class="form-group">
                    <label>メモ</label>
                    <input type="text" class="form-control" placeholder="メモを入力" name="memo">
                </div>

                <!-- 送信ボタン -->
                <button type="submit" class="btn btn-default btn-success" id="subbtn">入力する</button>
            </form>
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
