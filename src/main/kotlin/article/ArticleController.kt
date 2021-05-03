package article

var articleRepository = ArticleRepository()
var util = Util()


class ArticleController {

    fun write(loginCheck : Boolean, userId : String?) {

        if (loginCheck == false) {
            println("로그인 후에 이용해 주세요.")
            return
        }

        articleRepository.addArticle(userId!!)

    }

    fun delete(loginCheck : Boolean, idx : Int) {
        if (loginCheck == false) {
            println("로그인 후에 이용해 주세요.")
            return
        }

        articleRepository.delArticle(idx)

        println("${idx}번 글이 삭제되었습니다.")
    }

    fun modify(loginCheck: Boolean, idx : Int) {
        if (loginCheck == false) {
            println("로그인 후에 이용해 주세요.")
            return
        }

        articleRepository.modifyArticle(idx)

        println("${idx}번 글을 수정하였습니다.")
    }

    fun list() {
        articleRepository.articleList()
    }

    fun listPaging(page : Int) {
        articleRepository.articleListPaging(page)
    }

    fun creatTestArticle() {
        articleRepository.testArticle()
    }

}