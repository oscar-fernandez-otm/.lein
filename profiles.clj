{:user {:plugins [[lein-difftest "2.0.0"]]
        :dependencies [[clj-kondo "2021.04.23" :exclusions [com.cognitect/transit-clj com.cognitect/transit-java cheshire org.clojure/tools.reader]]]
        :aliases {"clj-kondo" ["run" "-m" "clj-kondo.main"]}}
 :repl {:pedantic? :warn


        :dependencies [;; banners 
;;                        [org.bouncycastle/bcprov-jdk15on "1.59"]
                       ;; expert
                       ;;                      [org.bouncycastle/bcprov-jdk15on "1.48"]
                       
                       [vvvvalvalval/scope-capture "0.3.2"]
                       [org.opensaml/xmltooling "1.4.4"]
                       [net.java.dev.jna/jna "4.2.2"]
                       [net.cgrand/macrovich "0.2.1"]
                       [potemkin "0.4.5"]
                       ;;[zcaudate/lucid "1.4.7" :exclusions [org.bouncycastle/bcprov-jdk15on zcaudate/lucid.package zcaudate/lucid.web]]
                       [org.clojure/tools.reader "1.3.4"]
                       [spyscope "0.1.7-SNAPSHOT" :exclusions [org.clojure/tools.reader org.clojure/clojure org.clojure/clojurescript]] ;; need to install locally
                       [com.google.errorprone/error_prone_annotations "2.1.3"]
                       [com.google.guava/guava "25.1-jre" :exclusions [com.google.code.findbugs/jsr305]]
                       [com.google.protobuf/protobuf-java "3.0.2"]
                       [org.clojure/tools.logging "0.4.1"]
                       [nrepl "0.9.0-beta3"]
                       #_[cljs-analyzer "0.1.0-SNAPSHOT"]
                       [cider/piggieback "0.5.3"]
                       
                       [criterium "0.4.4"]]
        :plugins [[cider/cider-nrepl "0.27.2"]
                  [refactor-nrepl "3.0.0" :exclusions [org.clojure/clojure nrepl]]]
        :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]
                       :init              (load-file (str
                                                      (System/getProperty "user.home")
                                                     "/.lein/user.clj"))}
        :injections [(require 'spyscope.core)
                     (require 'sc.api)]}}
