package com.livinglifetechway.quickpermissionskotlin.util

data class QuickPermissionsOptions(
    var handleRationale: Boolean = true,
    var rationaleMessage: String = "",
    var handlePermanentlyDenied: Boolean = true,
    var permanentlyDeniedMessage: String = "",
    var preRationaleAction: (() -> Unit)? = null,
    var rationaleMethod: ((QuickPermissionsRequest) -> Unit)? = null,
    var permanentDeniedMethod: ((QuickPermissionsRequest) -> Unit)? = null,
    var permissionsDeniedMethod: ((QuickPermissionsRequest) -> Unit)? = null
)
