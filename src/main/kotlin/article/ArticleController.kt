package article

var articleRepository = ArticleRepository()
var util = Util()


class ArticleController {

    fun addArticle(userId : String) {

        articleRepository.lastIdx++

        print("제목 : ")
        val subject = readLine()!!.trim()

        print("내용 : ")
        val contents = readLine()!!.trim()

        var article = Article(
            articleRepository.lastIdx,
            subject,
            contents,
            util.getNowDate(),
            util.getNowDate(),
            userId
        )

        articleRepository.articleList.add(article)

        println("${articleRepository.lastIdx}번 글이 추가되었습니다.")

    }

    fun delArticle(idx : Int) {
        articleRepository.articleList.removeAt(idx)

        println("${idx}번 글이 삭제되었습니다.")
    }

    fun mofifyArticle(idx : Int, article : Article) {
        articleRepository.articleList.set(idx, article)

        println("${idx}번 글을 수정하였습니다.")
    }

    fun articleList() {

        var list = articleRepository.articleList

        var reverseList = list.reversed()

        println("글번호 / 제목 / 내용 / 작성자 / 작성일")
        for (article in reverseList) {
            println("${article.idx} / ${article.subject} / ${article.contents} / ${article.userId} / ${article.regDate}")
        }
    }

    fun articleListPaging(page : Int) {

        var list = articleRepository.articleList

        var reverseList = list.reversed()

        var startIndex = ((page-1) * 10) +1
        var endIndex = (page * 10)

        println("글번호 / 제목 / 내용 / 작성자 / 작성일")
        for (x in startIndex..endIndex) {
            println("${reverseList[x].idx} / ${reverseList[x].subject} / ${reverseList[x].contents} / ${reverseList[x].userId} / ${reverseList[x].regDate}")
        }

    }

    fun testArticle() {
        for (x in 1.. 100) {

            var article = Article(x, "제목${x}", "내용${x}", util.getNowDate(), util.getNowDate(), "작성자${x}" )
            articleRepository.articleList.add(article)
        }

    }

}