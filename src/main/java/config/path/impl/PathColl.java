package config.path.impl;

import config.path.IPath;
import config.path.IPathColl;

import java.util.ArrayList;
import java.util.List;

public abstract class PathColl implements IPathColl {

    private List<IPath> paths;

    public PathColl() {
        paths = new ArrayList<>();
        init();
    }

    @Override
    public List<IPath> getPaths() {
        return paths;
    }


    @Override
    public void addPath(String path, Object defaultValue) {
        paths.add(new Path(path, defaultValue));
    }
}
