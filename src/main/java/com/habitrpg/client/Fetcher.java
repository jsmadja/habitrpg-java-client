package com.habitrpg.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import static com.google.common.io.ByteStreams.toByteArray;
import static com.google.common.io.Closeables.closeQuietly;

public class Fetcher {

    private static final Logger LOG = LoggerFactory.getLogger(Fetcher.class);

    private Map<String, String> headers;

    public Fetcher(Map<String, String> headers) {
        this.headers = headers;
    }

    public String fetch(String strUrl) throws IOException {
        URL url = new URL(strUrl);
        InputStream stream = null;
        try {
            URLConnection urlConnection = prepareConnection(url);
            stream = new GZIPInputStream(urlConnection.getInputStream());
        } catch (IOException exception) {
            stream = prepareConnection(url).getInputStream();
        }
        String content = new String(toByteArray(stream));
        closeQuietly(stream);
        LOG.debug(content);
        return content;
    }

    private URLConnection prepareConnection(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        for (Map.Entry<String, String> header : headers.entrySet()) {
            connection.setRequestProperty(header.getKey(), header.getValue());
        }
        return connection;
    }
}
