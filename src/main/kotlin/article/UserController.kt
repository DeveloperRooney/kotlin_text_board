package article

var userRepository = UserRepository()

class UserController {

    fun joinUser() {

        print("아이디 : ")
        val userId = readLine()!!.trim()

        print("비밀번호 : ")
        val userPass = readLine()!!.trim()

        print("이름 : ")
        val userName = readLine()!!.trim()

        print("이메일 : ")
        val userEmail = readLine()!!.trim()

        print("전화번호 : ")
        val userTel = readLine()!!.trim()

        val userIdx = userRepository.lastIdx++

        var user = User(userIdx, userId, userPass, userName, userEmail, userTel)

        userRepository.userList.add(user)

        println("${userName}님 가입을 환영합니다.")

    }

    fun userLogin():String? {

        print("아이디 : ")
        val userId = readLine()!!.trim()

        print("비밀번호 : ")
        val userPass = readLine()!!.trim()

        val userList = userRepository.userList

        for (user in userList) {
            if (user.userId == userId) {
                if (user.userPass == userPass) {
                    println("${user.userName}님, 로그인이 완료되었습니다.")
                    return user.userName
                }else if (user.userPass != userPass) {
                    println("비밀번호가 일치하지 않습니다.")
                    return null
                }

            }
        }
        println("존재하지 않는 아이디입니다.")

        return null

    }


    fun testUser() {
        for (x in 1.. 100) {

            var user = User(x, "userid${x}", "userpass${x}", "userName${x}", "userEmail${x}", "userTel${x}")
            userRepository.userList.add(user)
        }

    }
}