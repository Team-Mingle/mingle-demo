package community.mingle.mingledemo.exception

import community.mingle.mingledemo.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus
class UniversityNotFoundException: ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "UNIVERSITY_NOT_FOUND",
    reasonMessage = "대학교 정보를 찾을 수 없습니다.",
)