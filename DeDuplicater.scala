package com.github.edgecaseberg 

import scala.collection.mutable.HashMap
import java.io.File

object DeDuplicator {

	var hashMap = HashMap[String, String]()
	var duplicates = List[File]()

	def add(f: File) {
		val hash = FileHash.apply(f.getCanonicalPath())	
		if (hashMap.contains(hash.hashString)) {
			duplicates = duplicates.::(f)
		} else {
			hashMap += (hash.hashString -> f.getCanonicalPath())
		}
	}

	def apply(rootFolderPath: String) {
		val fileListing = new FileListing(rootFolderPath)
		fileListing.collectAndDo(DeDuplicator.add)
	}

	def reset {
		hashMap = HashMap[String, String]()
		duplicates = List[File]()
	}

}
