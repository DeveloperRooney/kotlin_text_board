package article

var userRepository = UserRepository()

class UserController {

    fun join() {
        userRepository.joinUser()
    }

    fun login():String? {

        return userRepository.userLogin()

    }

    fun testUser() {
        userRepository.testUser()
    }

}