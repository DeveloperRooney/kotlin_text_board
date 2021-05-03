package article

fun main() {

    var articleController = ArticleController()
    var userController = UserController()

    articleController.creatTestArticle()

    userController.testUser()


    println("=== 게시판 프로그램 시작 ===")

    var loginCheck = false
    var loginUserName : String? = ""

    while(true) {

        if (loginCheck == true) {
            print("${loginUserName} : ")
        } else {
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


        when (actionPath) {


            // 게시판 글 관련
            "/article/write" -> {
                articleController.write(loginCheck, loginUserName)

            }

            "/article/delete" -> {
                articleController.delete(loginCheck, paramMap["idx"]!!.toInt())

            }

            "/article/modify" -> {
                articleController.modify(loginCheck, paramMap["idx"]!!.toInt())

            }

            "/article/list" -> {
                if (paramMap["page"] == null) {
                    articleController.list()
                } else if (paramMap["page"] != null) {
                    articleController.listPaging(paramMap["page"]!!.toInt())
                }

            }

            // 유저 관련

            "/user/join" -> {
                userController.join()
            }

            "/user/login" -> {
                loginUserName =  userController.login()

                if (loginUserName != null) {
                    loginCheck = true
                }else {
                    false
                }
            }

            "/user/logout" -> {
                loginCheck = false
            }


            // 시스템 종료

            "/system/exit" -> {
                println("=== 게시판 프로그램 종료 ===")
                break
            }


            else -> {
                println("존재하지 않는 명령어입니다.")

            }


        }
    }
}