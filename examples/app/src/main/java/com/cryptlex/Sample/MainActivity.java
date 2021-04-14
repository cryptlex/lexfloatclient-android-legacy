package com.cryptlex.Sample;
import com.cryptlex.lexactivator.LexActivator;
import com.cryptlex.lexactivator.LexActivatorException;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		try {
            CallbackEventListener eventListener = new CallbackEventListener();
            LexFloatClient.SetHostProductId("PASTE_PRODUCT_ID");
            LexFloatClient.SetHostUrl("http://localhost:8090");
            LexFloatClient.AddLicenseCallbackListener(eventListener);

            LexFloatClient.RequestFloatingLicense();
            System.out.println("Success! License acquired.");

            System.out.println("Press Enter to drop the license ...");
            System.in.read();

            LexFloatClient.DropFloatingLicense();
            System.out.println("Success! License dropped successfully.");
        } catch (LexFloatClientException ex) {
            System.out.println(ex.getCode() + ": " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
      
    }

}
