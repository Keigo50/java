<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="stylesheet" href="reset.css" />
        <link rel="stylesheet" href="style.css"  />
        <title>AQuality</title>
    </head>

    <body>
        <header>
            <div class="header">
                <img src="sample.jpg" width="200px" height="40px" alt="logo" />
                <div class="header_menu">a</div>
            </div>
        </header>


        <div class="main">
            <div class="main_content">
                <div class="main_date">
                    今日の日付<br/> 年月日
                </div>
                <div class="main_list">
                    <label>
                        <select name="example">
                            <option value="収入・支出">収入・支出</option>
                            <option value="収入">収入</option>
                            <option value="支出">支出</option>
                        </select>
                    </label>
                </div>
                <div class="main_items">
                    <div class="items">
                        日付
                    </div>
                    <div class="items">
                        カテゴリ
                    </div>
                    <div class="items">
                        金額
                    </div>
                    <div class="items">
                        入金先
                    </div>
                    <div class="items">
                        支払元
                    </div>
                    <div class="items">
                        お店の名前
                    </div>
                    <div class="items">
                        メモ
                    </div>
                    <div class="items"></div>
                    <div class="items"></div>
                    <div class="items"></div>
                </div>
                <div class="main_table">
                    <table border="1">
                        <thead>

                        </thead>
                        <tbody>

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


    </body>

    </html>
