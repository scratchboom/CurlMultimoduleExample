package kcurl

import kotlinx.cinterop.toKString

fun printContent(url: String) {
    val client = curl.curl_easy_init()
    if (client != null) {
        curl.curl_easy_setopt(client, curl.CURLOPT_URL, url)
        curl.curl_easy_setopt(client, curl.CURLOPT_FOLLOWLOCATION, 1L)
        val res = curl.curl_easy_perform(client)
        if (res != curl.CURLE_OK) {
            println("curl_easy_perform() failed ${curl.curl_easy_strerror(res)?.toKString()}")
        }
        curl.curl_easy_cleanup(client)
    }
}