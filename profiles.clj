{:user {:plugins [[lein-difftest "2.0.0"]]}
 :repl {:pedantic? :warn
        :dependencies [#_[org.bouncycastle/bcprov-jdk15on "1.48"]
                       [org.opensaml/xmltooling "1.4.4"]
                       [net.java.dev.jna/jna "4.2.2"]
                       [net.cgrand/macrovich "0.2.1"]
                       [zcaudate/lucid "1.4.4" :exclusions [org.bouncycastle/bcprov-jdk15on zcaudate/lucid.package]]
                       [org.clojure/tools.reader "1.3.2"]
                       [spyscope "0.1.7-SNAPSHOT" :exclusions [org.clojure/tools.reader org.clojure/clojure]] ;; need to install locally
                       [com.google.errorprone/error_prone_annotations "2.1.3"]
                       [com.google.guava/guava "22.0" :exclusions [com.google.code.findbugs/jsr305]]
                       [com.google.protobuf/protobuf-java "3.0.2"]
                       [org.clojure/tools.logging "0.4.1"]
                       [nrepl "0.6.0"]
                       #_[cljs-analyzer "0.1.0-SNAPSHOT"]
                       [cider/piggieback "0.4.2"]
                       [criterium "0.4.4"]]
        :plugins [[cider/cider-nrepl "0.22.4"]
                  [refactor-nrepl "2.4.0" :exclusions [org.clojure/clojure nrepl]]]
        :repl-options {;;:nrepl-middleware [cider.piggieback/wrap-cljs-repl]
                       :init             (load-file (str
                                                     (System/getProperty "user.home")
                                                     "/.lein/user.clj"))}
        :injections [(require 'spyscope.core)]}}
