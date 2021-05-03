package article

class ArticleRepository {

    var lastIdx = 0

    val articleList = mutableListOf<Article>()

    fun addArticle(userId : String) {

        lastIdx++

        print("제목 : ")
        val subject = readLine()!!.trim()

        print("내용 : ")
        val contents = readLine()!!.trim()

        var article = Article(
            lastIdx,
            subject,
            contents,
            util.getNowDate(),
            util.getNowDate(),
            userId
        )

        articleList.add(article)

        println("${lastIdx}번 글이 추가되었습니다.")

    }

    fun delArticle(idx : Int) {
        articleList.removeAt(idx)

        println("${idx}번 글이 삭제되었습니다.")
    }


    fun modifyArticle(idx : Int) {

        print("제목 : ")
        val subject = readLine()!!.trim()

        print("내용 : ")
        val contents = readLine()!!.trim()

        var article : Article? = null

        var index = 0

        for (x in 0 until articleList.size) {
            if (articleList[x].idx == idx) {
                article = articleList[x]
                index = x
                break
            }
        }

        article?.subject = subject
        article?.contents = contents
        article?.updateDate = util.getNowDate()

        if (article != null) {
            articleList.set(index, article)
        }
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

//        var total = reverseList.size
//
//        var countList = 10
//
//        var totalPage = total / countList
//
//        if (total / countList == 0) {
//            total++
//        }

        var startIndex = ((page-1) * 10) +1
        var endIndex = (page * 10)

        println("글번호 / 제목 / 내용 / 작성자 / 작성일")
        for (x in startIndex..endIndex) {
            println("${reverseList[x].idx} / ${reverseList[x].subject} / ${reverseList[x].contents} / ${reverseList[x].userId} / ${reverseList[x].regDate}")
        }

    }

    fun testArticle() {
        for (x in 1.. 103) {
            lastIdx++
            var article = Article(lastIdx, "제목${x}", "내용${x}", util.getNowDate(), util.getNowDate(), "작성자${x}" )
            articleRepository.articleList.add(article)
        }

    }

}