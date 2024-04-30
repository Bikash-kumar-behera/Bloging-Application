import { NextRequest, NextResponse } from "next/server";
import axios from "axios";

export async function GET(request) {
    try {
        const url = process.env.BACKEND_URL + "/post/all";
        const posts = await axios.get(url);

        return NextResponse.json({
            message: "Post featch successful",
            data: posts.data,
        });
    } catch (error) {
        return NextResponse.json({ error: error.message }, { status: 400 });
    }
}
