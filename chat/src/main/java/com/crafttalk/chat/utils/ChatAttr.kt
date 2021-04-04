package com.crafttalk.chat.utils

import android.content.Context
import android.content.res.TypedArray
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.crafttalk.chat.R
import com.crafttalk.chat.presentation.helper.extensions.getColorOrNull
import com.crafttalk.chat.presentation.helper.extensions.getDimensionOrNull
import com.crafttalk.chat.presentation.helper.extensions.getResourceIdOrNull
import com.crafttalk.chat.presentation.helper.ui.getSizeScreenInPx
import java.util.*

class ChatAttr
private constructor(
    attrArr: TypedArray,
    context: Context
) {

    init {
        attrArr.getInt(R.styleable.ChatView_auth, -1).let { if (it != -1) ChatParams.authType = AuthType.values()[it] }
        attrArr.getInt(R.styleable.ChatView_timeDelayed, 0).let { ChatParams.timeDelayed = it.toLong() }
        attrArr.getString(R.styleable.ChatView_urlSocketNameSpace)?.let { ChatParams.urlSocketNameSpace = it }
        attrArr.getString(R.styleable.ChatView_urlSocketHost)?.let { ChatParams.urlSocketHost = it }
        attrArr.getString(R.styleable.ChatView_urlUploadNameSpace)?.let { ChatParams.urlUploadNameSpace = it }
        attrArr.getString(R.styleable.ChatView_urlUploadHost)?.let { ChatParams.urlUploadHost = it }
        attrArr.getString(R.styleable.ChatView_fileProviderAuthorities)?.let { ChatParams.fileProviderAuthorities = it }
    }

    private val widthScreenInPx = getSizeScreenInPx(context).first.toFloat()
    private val heightScreenInPx = getSizeScreenInPx(context).second.toFloat()

    val locale: Locale? = attrArr.getString(R.styleable.ChatView_locale_language)?.let { language ->
        val country = attrArr.getString(R.styleable.ChatView_locale_country) ?: ""
        Locale(language, country)
    }

    val colorBackgroundUserMessage = attrArr.getColor(R.styleable.ChatView_color_bg_user_message, ContextCompat.getColor(context, R.color.default_color_bg_user_message))
    val colorBackgroundOperatorMessage = attrArr.getColor(R.styleable.ChatView_color_bg_operator_message, ContextCompat.getColor(context, R.color.default_color_bg_server_message))
    val colorBackgroundOperatorAction = attrArr.getColor(R.styleable.ChatView_color_bg_operator_action, ContextCompat.getColor(context, R.color.default_color_bg_server_action))
    val colorBordersOperatorAction = attrArr.getColor(R.styleable.ChatView_color_borders_operator_action, ContextCompat.getColor(context, R.color.default_color_borders_server_action))

    val colorMain = attrArr.getColor(R.styleable.ChatView_color_main, ContextCompat.getColor(context, R.color.default_color_main))
    val colorTextInternetConnectionWarning = attrArr.getColor(R.styleable.ChatView_color_text_warning, ContextCompat.getColor(context, R.color.default_color_text_warning))
    val colorTextInfo = attrArr.getColor(R.styleable.ChatView_color_company, ContextCompat.getColor(context, R.color.default_color_info))
    val colorTextUserMessage = attrArr.getColor(R.styleable.ChatView_color_text_user_message, ContextCompat.getColor(context, R.color.default_color_text_user_message))
    val colorTextOperatorMessage = attrArr.getColor(R.styleable.ChatView_color_text_operator_message, ContextCompat.getColor(context, R.color.default_color_text_server_message))
    val colorTextOperatorAction = attrArr.getColor(R.styleable.ChatView_color_text_operator_action, ContextCompat.getColor(context, R.color.default_color_text_server_action))
    val colorTextFileName = attrArr.getColor(R.styleable.ChatView_color_text_file_name, ContextCompat.getColor(context, R.color.default_color_info))
    val colorTextFileSize = attrArr.getColor(R.styleable.ChatView_color_text_file_size, ContextCompat.getColor(context, R.color.default_color_info))
    val colorTextUserMessageAuthor = attrArr.getColor(R.styleable.ChatView_color_text_user_message_author, ContextCompat.getColor(context, R.color.default_color_info))
    val colorTextOperatorMessageAuthor = attrArr.getColor(R.styleable.ChatView_color_text_operator_message_author, ContextCompat.getColor(context, R.color.default_color_info))
    private val colorUserMessageTime = attrArr.getColor(R.styleable.ChatView_color_user_message_time, ContextCompat.getColor(context, R.color.default_color_info))
    val colorUserFileMessageTime = attrArr.getColorOrNull(R.styleable.ChatView_color_user_file_message_time) ?: colorUserMessageTime
    val colorUserGifMessageTime = attrArr.getColorOrNull(R.styleable.ChatView_color_user_gif_message_time) ?: colorUserMessageTime
    val colorUserImageMessageTime = attrArr.getColorOrNull(R.styleable.ChatView_color_user_image_message_time) ?: colorUserMessageTime
    val colorUserTextMessageTime = attrArr.getColorOrNull(R.styleable.ChatView_color_user_text_message_time) ?: colorUserMessageTime
    private val colorOperatorMessageTime = attrArr.getColor(R.styleable.ChatView_color_operator_message_time, ContextCompat.getColor(context, R.color.default_color_info))
    val colorOperatorFileMessageTime = attrArr.getColorOrNull(R.styleable.ChatView_color_operator_file_message_time) ?: colorOperatorMessageTime
    val colorOperatorGifMessageTime = attrArr.getColorOrNull(R.styleable.ChatView_color_operator_gif_message_time) ?: colorOperatorMessageTime
    val colorOperatorImageMessageTime = attrArr.getColorOrNull(R.styleable.ChatView_color_operator_image_message_time) ?: colorOperatorMessageTime
    val colorOperatorTextMessageTime = attrArr.getColorOrNull(R.styleable.ChatView_color_operator_text_message_time) ?: colorOperatorMessageTime
    private val colorUserMessageStatus = attrArr.getColor(R.styleable.ChatView_color_user_message_status, ContextCompat.getColor(context, R.color.default_color_info))
    val colorUserFileMessageStatus = attrArr.getColorOrNull(R.styleable.ChatView_color_user_file_message_status) ?: colorUserMessageStatus
    val colorUserGifMessageStatus = attrArr.getColorOrNull(R.styleable.ChatView_color_user_gif_message_status) ?: colorUserMessageStatus
    val colorUserImageMessageStatus = attrArr.getColorOrNull(R.styleable.ChatView_color_user_image_message_status) ?: colorUserMessageStatus
    val colorUserTextMessageStatus = attrArr.getColorOrNull(R.styleable.ChatView_color_user_text_message_status) ?: colorUserMessageStatus
    val colorTextDateGrouping = attrArr.getColor(R.styleable.ChatView_color_text_date_grouping, ContextCompat.getColor(context, R.color.default_color_info))
    val colorTextLink = attrArr.getColor(R.styleable.ChatView_color_text_link, ContextCompat.getColor(context, R.color.default_color_text_link))

    val drawableProgressIndeterminate = attrArr.getDrawable(R.styleable.ChatView_drawable_progress_indeterminate)
    val drawableFileIcon = attrArr.getDrawable(R.styleable.ChatView_drawable_file_icon)

    val sizeTextInternetConnectionWarning = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_warning, context.resources.getDimensionPixelSize(R.dimen.default_size_warning)).toFloat()
    val sizeTextInfoText = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_info, context.resources.getDimensionPixelSize(R.dimen.default_size_info)).toFloat()
    val sizeTextUserMessage = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_user_message, context.resources.getDimensionPixelSize(R.dimen.default_size_user_message)).toFloat()
    val sizeTextOperatorMessage = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_operator_message, context.resources.getDimensionPixelSize(R.dimen.default_size_server_message)).toFloat()
    val sizeTextOperatorAction = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_operator_action, context.resources.getDimensionPixelSize(R.dimen.default_size_server_action)).toFloat()
    val sizeTextFileName = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_file_name, context.resources.getDimensionPixelSize(R.dimen.default_size_info)).toFloat()
    val sizeTextFileSize = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_file_size, context.resources.getDimensionPixelSize(R.dimen.default_size_info)).toFloat()
    val sizeUserMessageAuthor = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_user_message_author, context.resources.getDimensionPixelSize(R.dimen.default_size_author)).toFloat()
    val sizeOperatorMessageAuthor = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_operator_message_author, context.resources.getDimensionPixelSize(R.dimen.default_size_author)).toFloat()
    val sizeOperatorMessageAuthorPreview = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_operator_message_author_preview, context.resources.getDimensionPixelSize(R.dimen.default_size_author_preview))
    val sizeUserMessageTime = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_user_message_time, context.resources.getDimensionPixelSize(R.dimen.default_size_time)).toFloat()
    val sizeOperatorMessageTime = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_operator_message_time, context.resources.getDimensionPixelSize(R.dimen.default_size_time)).toFloat()
    val sizeTextDateGrouping = attrArr.getDimensionPixelSize(R.styleable.ChatView_size_text_date_grouping, context.resources.getDimensionPixelSize(R.dimen.default_size_info)).toFloat()

    val widthItemUserTextMessage = attrArr.getDimensionOrNull(R.styleable.ChatView_width_item_user_text_message)?.toInt()
    val widthItemOperatorTextMessage = attrArr.getDimensionOrNull(R.styleable.ChatView_width_item_operator_text_message)?.toInt()
    val widthItemUserFileIconMessage = attrArr.getDimensionOrNull(R.styleable.ChatView_width_item_user_file_icon_message)?.toInt()
    val widthItemOperatorFileIconMessage = attrArr.getDimensionOrNull(R.styleable.ChatView_width_item_operator_file_icon_message)?.toInt()
    val widthItemUserFilePreviewWarningMessage = (attrArr.getDimensionOrNull(R.styleable.ChatView_width_item_user_file_preview_warning_message) ?: (widthScreenInPx / 2)).toInt()
    val widthItemOperatorFilePreviewWarningMessage = (attrArr.getDimensionOrNull(R.styleable.ChatView_width_item_operator_file_preview_warning_message) ?: (widthScreenInPx / 2)).toInt()
    val widthElongatedItemUserFilePreviewMessage = (attrArr.getDimensionOrNull(R.styleable.ChatView_width_elongated_item_user_file_preview_message) ?: (0.7f * widthScreenInPx)).toInt()
    val widthElongatedItemOperatorFilePreviewMessage = (attrArr.getDimensionOrNull(R.styleable.ChatView_width_elongated_item_operator_file_preview_message) ?: (0.7f * widthScreenInPx)).toInt()
    val heightElongatedItemUserFilePreviewMessage = (attrArr.getDimensionOrNull(R.styleable.ChatView_height_elongated_item_user_file_preview_message) ?: (0.4f * heightScreenInPx)).toInt()
    val heightElongatedItemOperatorFilePreviewMessage = (attrArr.getDimensionOrNull(R.styleable.ChatView_height_elongated_item_operator_file_preview_message) ?: (0.4f * heightScreenInPx)).toInt()

    private val resFontFamilyAllText = attrArr.getResourceIdOrNull(R.styleable.ChatView_resource_font_family_all_text)
    val resFontFamilyUserMessage = resFontFamilyAllText ?: attrArr.getResourceIdOrNull(R.styleable.ChatView_resource_font_family_user_message)
    val resFontFamilyOperatorMessage = resFontFamilyAllText ?: attrArr.getResourceIdOrNull(R.styleable.ChatView_resource_font_family_operator_message)
    val resFontFamilyOperatorAction = resFontFamilyAllText ?: attrArr.getResourceIdOrNull(R.styleable.ChatView_resource_font_family_operator_action)
    val resFontFamilyFileInfo = resFontFamilyAllText ?: attrArr.getResourceIdOrNull(R.styleable.ChatView_resource_font_family_file_info)
    val resFontFamilyMessageAuthor = resFontFamilyAllText ?: attrArr.getResourceIdOrNull(R.styleable.ChatView_resource_font_family_message_author)
    val resFontFamilyMessageTime = resFontFamilyAllText ?: attrArr.getResourceIdOrNull(R.styleable.ChatView_resource_font_family_message_time)
    val resFontFamilyMessageDate = resFontFamilyAllText ?: attrArr.getResourceIdOrNull(R.styleable.ChatView_resource_font_family_message_date)

    val marginStartMediaFile = attrArr.getDimension(R.styleable.ChatView_margin_start_media_file, context.resources.getDimension(R.dimen.default_margin_start_media_file)).toInt()
    val marginEndMediaFile = attrArr.getDimension(R.styleable.ChatView_margin_end_media_file, context.resources.getDimension(R.dimen.default_margin_end_media_file)).toInt()
    val marginTopMediaFile = attrArr.getDimension(R.styleable.ChatView_margin_top_media_file, context.resources.getDimension(R.dimen.default_margin_top_media_file)).toInt()
    val marginBottomMediaFile = attrArr.getDimension(R.styleable.ChatView_margin_bottom_media_file, context.resources.getDimension(R.dimen.default_margin_bottom_media_file)).toInt()

    val companyName = attrArr.getString(R.styleable.ChatView_company_name) ?: context.getString(R.string.chat_name_company)
    val showCompanyName = attrArr.getBoolean(R.styleable.ChatView_show_company_name, false)
    val showInternetConnectionState = attrArr.getBoolean(R.styleable.ChatView_show_internet_connection_state, true)
    val showUpperLimiter = attrArr.getBoolean(R.styleable.ChatView_show_upper_limiter, true)
    val showStartingProgress = attrArr.getBoolean(R.styleable.ChatView_show_starting_progress, true)

    val showUserMessageAuthor = attrArr.getBoolean(R.styleable.ChatView_show_user_message_author, true)
    val showUserMessageStatus = attrArr.getBoolean(R.styleable.ChatView_show_user_message_status, true)

    val bgUserMessageResId = attrArr.getResourceId(R.styleable.ChatView_resource_bg_user_message, R.drawable.background_item_simple_user_message)
    val bgOperatorMessageResId = attrArr.getResourceId(R.styleable.ChatView_resource_bg_operator_message, R.drawable.background_item_simple_server_message)

    val layoutItemUserTextMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_user_text_message)
    val layoutItemUserImageMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_user_image_message)
    val layoutItemUserGifMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_user_gif_message)
    val layoutItemUserFileMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_user_file_message)
    val layoutItemUserUnionMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_user_union_message)
    val layoutItemOperatorTextMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_operator_text_message)
    val layoutItemOperatorImageMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_operator_image_message)
    val layoutItemOperatorGifMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_operator_gif_message)
    val layoutItemOperatorFileMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_operator_file_message)
    val layoutItemOperatorUnionMessage: Int? = attrArr.getResourceIdOrNull(R.styleable.ChatView_layout_item_operator_union_message)

    val drawableBackgroundSignInButton: Drawable = DrawableCompat.wrap(ContextCompat.getDrawable(context, R.drawable.background_sign_in_auth_form)!!).apply {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            DrawableCompat.setTint(this, colorMain)
        } else {
            this.mutate().setColorFilter(colorMain, PorterDuff.Mode.SRC_IN)
        }
    }

    companion object {
        @Volatile private var INSTANCE: ChatAttr? = null

        fun getInstance(attrArr: TypedArray? = null, context: Context? = null): ChatAttr =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: ChatAttr(attrArr!!, context!!).also { INSTANCE = it }
            }
    }

}