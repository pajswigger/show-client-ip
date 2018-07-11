package burp


class BurpExtender: IBurpExtender {
    override fun registerExtenderCallbacks(callbacks: IBurpExtenderCallbacks) {
        callbacks.setExtensionName("Show Client IP")
        callbacks.registerProxyListener(ProxyListener())
    }
}


class ProxyListener: IProxyListener {
    override fun processProxyMessage(messageIsRequest: Boolean, message: IInterceptedProxyMessage) {
        message.messageInfo.comment = message.clientIpAddress.hostAddress
    }
}
