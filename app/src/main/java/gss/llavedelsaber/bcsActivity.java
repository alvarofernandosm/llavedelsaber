package gss.llavedelsaber;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.scandit.barcodepicker.BarcodePicker;
import com.scandit.barcodepicker.OnScanListener;
import com.scandit.barcodepicker.ScanSession;
import com.scandit.barcodepicker.ScanSettings;
import com.scandit.barcodepicker.ScanditLicense;
import com.scandit.recognition.Barcode;

import java.util.List;


/**
 * @version 2.0
 * @author Alvaro Fernando Salgado
 * @serial ALALFELASAROMO
 * Designed For Global System Solutions S.A.S
 */
public class bcsActivity extends AppCompatActivity implements OnScanListener {

    private BarcodePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        setContentView(R.layout.activity_bcs);

        init_System();
        init_UI();

    }

    /**
     * Init all basics app user interface requirements
     */
    private void init_UI() {
<<<<<<< HEAD
        assert (findViewById(R.id.ll_camera_scanner)) != null && picker != null;
        ((LinearLayout) findViewById(R.id.ll_camera_scanner)).addView(picker);
=======
>>>>>>> origin/master
    }

    /**
     * Init the basics app logical requirements
     */
    private void init_System() {
        ScanditLicense.setAppKey(gss.llavedelsaber.system.constants.BAR_CODE_SCANNER_KEY);
        ScanSettings settings = ScanSettings.create();
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_EAN13, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_UPCA, true);
        picker = new BarcodePicker(this, settings);
        picker.setOnScanListener(this);
    }

    @Override
    public void didScan(final ScanSession scanSession) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                try {
                    assert (findViewById(R.id.tv_input_document)) != null;
                    ((TextView) findViewById(R.id.tv_input_document)).setText(scanSession.getAllRecognizedCodes().get(scanSession.getAllRecognizedCodes().size()-1).getData());
                } catch (IndexOutOfBoundsException e) {
                    Log.e("Error", e.getMessage());
                }
            }
        });
    }

    @Override
    protected void onPause() {
        picker.stopScanning();
        super.onPause();
    }

    @Override
    protected void onResume() {
        picker.startScanning();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        picker.stopScanning();
        super.onDestroy();
    }
}
