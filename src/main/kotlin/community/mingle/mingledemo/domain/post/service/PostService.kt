package community.mingle.mingledemo.domain.post.service

import community.mingle.mingledemo.domain.member.service.MemberService
import community.mingle.mingledemo.domain.post.entity.Post
import community.mingle.mingledemo.domain.post.repository.PostRepository
import community.mingle.mingledemo.enums.CategoryType
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class PostService(
    private val memberService: MemberService,
    private val postRepository: PostRepository,
) {

    fun getUnivPosts(
        memberId: Long,
        categoryType: CategoryType,
        pageRequest: PageRequest
    ): MutableList<Post> {
        val memberDto = memberService.getById(memberId)
        val posts = postRepository.findAllByCategoryTypeAndBoardTypeIsUnivAndMemberUniversityId(
            categoryType = categoryType,
            universityId = memberDto.university.id!!,
            pageable = pageRequest
        )
        return posts.content
    }

    fun getTotalPosts(
        categoryType: CategoryType,
        pageRequest: PageRequest
    ): MutableList<Post> {
        val posts = postRepository.findAllByCategoryTypeAndBoardTypeIsTotal(
            categoryType = categoryType,
            pageable = pageRequest
        )
        return posts.content
    }

}