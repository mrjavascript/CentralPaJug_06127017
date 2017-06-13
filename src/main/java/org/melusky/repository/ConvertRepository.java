package org.melusky.repository;

import java.net.MalformedURLException;

/**
 * Created by mikem on 6/12/2017.
 */
public interface ConvertRepository {
    Double convertToF_Soap(Double C) throws MalformedURLException;

    Double convertToF_Static(Double c);
}
