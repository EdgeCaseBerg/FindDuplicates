package com.github.edgecaseberg

import java.io._
import scala.collection.JavaConversions._


class FileListing(rootFolderPath: String) {
	val root = new File(rootFolderPath)
	require(root.isDirectory)

	def collect : List[File] = {
		root.listFiles.toList.map { f =>
			if (f.isDirectory) {
				new FileListing(f.getCanonicalPath()).collect
			} else {
				List(f)
			}
		}.flatten
	}

	def collectAndDo(func : (File) => Unit) : List[File] = { 
		root.listFiles.toList.map { f => 
			if (f.isDirectory) {
				new FileListing(f.getCanonicalPath()).collectAndDo(func)
			} else {
				func(f)
			}
		}.flatten
	}
}
