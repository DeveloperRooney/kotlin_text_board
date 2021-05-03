package article

fun main() {

    var articleController = ArticleController()
    var userController = UserController()

    articleController.testArticle()

    userController.testUser()


    println("=== 게시판 프로그램 시작 ===")

    var loginCheck = false
    var loginUserName = ""

    while(true) {

        if (loginCheck == true) {
            print("${loginUserName} : ")
        }else {
            print("명령어 입력 : ")
        }

        val command = readLine()!!.trim()

        val request = command!!.split("?", limit = 2)

        val actionPath = request[0]

        val paramMap = mutableMapOf<String, String>()

        if (request.lastIndex != 0) {
            val actionParam = request[1].split("&")


            for (value in actionParam) {
                var valueBits = value.split("=")
                paramMap[valueBits[0]] = valueBits[1]
            }


        }


        // 게시판 관련
        if (actionPath == "/article/write") {

            if (loginCheck == false) {
                println("로그인 후에 이용 가능합니다.")
                continue
            }

            articleController.addArticle(loginUserName)

        }


        else if (actionPath.startsWith("/article/modify")) {

            if (loginCheck == false) {
                println("로그인 후에 이용 가능합니다.")
                continue
            }

        }


        else if (actionPath.startsWith("/article/delete")) {

            if (loginCheck == false) {
                println("로그인 후에 이용 가능합니다.")
                continue
            }

        }



        else if (actionPath.startsWith("/article/list") && paramMap["page"] == null) {

            if (loginCheck == false) {
                println("로그인 후에 이용 가능합니다.")
                continue
            }

            articleController.articleList()

        }

        else if (actionPath.startsWith("/article/list") && paramMap["page"] != null) {

            if (loginCheck == false) {
                println("로그인 후에 이용 가능합니다.")
                continue
            }

            var page = paramMap["page"]!!.toInt()

            articleController.articleListPaging(page)

        }



        // 유저 관련

        else if (actionPath == "/user/join") {
            userController.joinUser()
        }

        else if (actionPath == "/user/login") {

            while(true) {
                var login = userController.userLogin()

                if (login != null) {
                    loginCheck = true
                    loginUserName = login
                    break
                }
            }
        }

        else if (actionPath == "/user/logout") {

            loginCheck = false
            println("로그아웃되었습니다.")

        }



        else {
            println("존재하지 않는 명령어입니다.")
        }

    }

}