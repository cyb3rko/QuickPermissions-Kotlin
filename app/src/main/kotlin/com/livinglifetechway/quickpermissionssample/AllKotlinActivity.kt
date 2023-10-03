package com.livinglifetechway.quickpermissionssample

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.livinglifetechway.quickpermissionskotlin.runWithPermissions
import com.livinglifetechway.quickpermissionskotlin.util.QuickPermissionsOptions
import com.livinglifetechway.quickpermissionskotlin.util.QuickPermissionsRequest
import com.livinglifetechway.quickpermissionssample.databinding.ActivityAllKotlinBinding

class AllKotlinActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "AllKotlinActivity"
    }

    // You can hardcode the options like this
    // However for the sample purpose the options is dynamically generated based on the
    // values you have selected from the activity
    private val quickPermissionsOption = QuickPermissionsOptions(
        rationaleMessage = "Custom rational message",
        permanentlyDeniedMessage = "Custom permanently denied message",
        preRationaleAction = { preRationaleMethod() },
        rationaleMethod = { rationaleCallback(it) },
        permanentDeniedMethod = { permissionsPermanentlyDenied(it) },
        permissionsDeniedMethod = { whenPermAreDenied(it) }
    )

    private lateinit var mBinding: ActivityAllKotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAllKotlinBinding.inflate(layoutInflater)

        mBinding.button.setOnClickListener {
            // create the quickpermissions object
            val options = QuickPermissionsOptions()
            options.handleRationale = mBinding.handleRationale.isChecked
            if (mBinding.customRationaleMessage.isChecked) {
                options.rationaleMessage = "Custom rational message"
            }
            if (mBinding.customRationaleMethod.isChecked) {
                options.rationaleMethod = { rationaleCallback(it) }
            }
            options.handlePermanentlyDenied = mBinding.handlePermanentlyDenied.isChecked
            if (mBinding.customPermanentlyDeniedMessage.isChecked) {
                options.permanentlyDeniedMessage = "Custom permanently denied message"
            }
            if (mBinding.preRationaleAction.isChecked) {
                options.preRationaleAction = { preRationaleMethod() }
            }
            if (mBinding.customPermanentlyDeniedMethod.isChecked) {
                options.permanentDeniedMethod = { permissionsPermanentlyDenied(it) }
            }
            if (mBinding.customDeniedMethod.isChecked) {
                options.permissionsDeniedMethod = { whenPermAreDenied(it) }
            }
            methodRequiresPermissions(options)
        }

        setContentView(mBinding.root)
    }

    private fun methodRequiresPermissions(quickPermissionsOptions: QuickPermissionsOptions) {
        runWithPermissions(
            Manifest.permission.WRITE_CALENDAR,
            Manifest.permission.RECORD_AUDIO,
            options = quickPermissionsOptions
        ) {
            Log.d(TAG, "methodRequiresPermissions: Cal and microphone permission granted")

            Toast.makeText(this, "Cal and microphone permission granted", Toast.LENGTH_LONG).apply {
                setGravity(Gravity.CENTER, 0, 0)
                show()
            }
        }
    }

    /**
     * This method will be called when permission is denied once or more often, handle it your way
     */
    private fun rationaleCallback(req: QuickPermissionsRequest) {
        // this will be called when permission is denied once or more time; handle it your way
        AlertDialog.Builder(this)
            .setTitle("Permissions Denied")
            .setMessage(
                "This is the custom rationale dialog. Please allow us to proceed asking for " +
                    "permissions again, or cancel to end the permission flow."
            )
            .setPositiveButton("Go Ahead") { _, _ -> req.proceed() }
            .setNegativeButton("cancel") { _, _ -> req.cancel() }
            .setCancelable(false)
            .show()
    }

    /**
     * This method will be called when some/all permissions required by the method are permanently
     * denied, handle it your way
     */
    private fun permissionsPermanentlyDenied(req: QuickPermissionsRequest) {
        AlertDialog.Builder(this)
            .setTitle("Permissions Denied")
            .setMessage(
                "This is the custom permissions permanently denied dialog. Please open app " +
                    "settings to open app settings for allowing permissions, or cancel to end" +
                    "the permission flow."
            )
            .setPositiveButton("App Settings") { _, _ -> req.openAppSettings() }
            .setNegativeButton("Cancel") { _, _ -> req.cancel() }
            .setCancelable(false)
            .show()
    }

    /**
     * This method will be called when permissions are not granted and the request method cannot be
     * called
     */
    private fun whenPermAreDenied(req: QuickPermissionsRequest) {
        AlertDialog.Builder(this)
            .setTitle("Permissions Denied")
            .setMessage(
                "This is the custom permissions denied dialog. " +
                    "\n${req.deniedPermissions.size}/${req.permissions.size} permissions denied"
            )
            .setPositiveButton(android.R.string.ok) { _, _ -> }
            .setCancelable(false)
            .show()
    }

    private fun preRationaleMethod() {
        Toast.makeText(this, "Requesting permissions", Toast.LENGTH_SHORT).show()
    }
}
