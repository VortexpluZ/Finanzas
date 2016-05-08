package tracker.money.finazas;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class Ubicacion implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    Activity finanzas;
    Button get_ubicacion;
    TextView ubicacion;
    Location mLastLocation;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    private double latitud = 0;
    private double longitud = 0;


    public Ubicacion(Activity finanzas)
    {
        this.finanzas = finanzas;
        ubicacion = (TextView) finanzas.findViewById(R.id.ubicacion);
        get_ubicacion = (Button)finanzas.findViewById(R.id.get_ubicacion);

        construirGoogleApiClient();

    }


    synchronized void construirGoogleApiClient()
    {
        mGoogleApiClient = new GoogleApiClient.Builder(finanzas)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    public void getUbicacion()
    {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(10000);

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (mLastLocation != null)
        {
            latitud = mLastLocation.getLatitude();
            longitud = mLastLocation.getLongitude();
        }
        else
        {
            mensajeAjustesGPS();
        }

        ubicacion.setText("Lat: " + latitud + "Long: " + longitud);

    }

    public void conectado() {
        mGoogleApiClient.connect();
    }


    public void desconectado() {
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,this);
        mGoogleApiClient.disconnect();

    }


    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public void onConnected(Bundle bundle) {
            getUbicacion();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location)
    {
        latitud = location.getLatitude();
        longitud = location.getLongitude();
        ubicacion.setText("Lat: " + latitud + "Long: " + longitud);
    }

    public void mensajeAjustesGPS()
    {

        final AlertDialog.Builder builder =  new AlertDialog.Builder(finanzas);
        final String action = Settings.ACTION_LOCATION_SOURCE_SETTINGS;
        final String message = "GPS Desactivado \nDesea abrir los Ajustes ?";

        builder.setMessage(message)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface d, int id) {
                                finanzas.startActivity(new Intent(action));
                                d.dismiss();
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface d, int id) {
                                d.cancel();
                            }
                        });
        builder.create().show();
    }
}
