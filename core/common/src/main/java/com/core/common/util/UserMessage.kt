package com.core.common.util
import com.core.common.R
open class UserMessage(val message: UiText? = null) {
    object LocationPermissionRequired :
        UserMessage(UiText.StringResource(R.string.permission_required_message))

    object SomethingWentWrong :
        UserMessage(UiText.StringResource(R.string.something_went_wrong))

    object UnknownHostException :
        UserMessage(UiText.StringResource(R.string.check_internet_connection))
}